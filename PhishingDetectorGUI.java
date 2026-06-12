import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class PhishingDetectorGUI {

    private static JTextArea resultArea;
    private static JButton analyzeBtn;
    private static GlowProgressBar progressBar;
    private static JLabel shieldLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PhishingDetectorGUI::createGUI);
    }

    public static void createGUI() {

        JFrame frame = new JFrame("Phishing URL Detector");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 580);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new CoolBackgroundPanel();
        mainPanel.setLayout(new BorderLayout(25, 25));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 60, 30, 60));

        // ===== HEADER =====
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);

        shieldLabel = new JLabel("🛡");
        shieldLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 30));
        shieldLabel.setForeground(new Color(0, 220, 255));
        header.add(shieldLabel, BorderLayout.WEST);

        JLabel title = new JLabel("Phishing URL Detector", JLabel.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(new Color(0, 220, 255));
        header.add(title, BorderLayout.CENTER);

        mainPanel.add(header, BorderLayout.NORTH);

        // ===== INPUT SECTION =====
        JPanel inputSection = new JPanel(new BorderLayout(10, 10));
        inputSection.setBackground(new Color(255, 255, 255, 25));
        inputSection.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel urlLabel = new JLabel("ENTER WEBSITE URL");
        urlLabel.setForeground(new Color(0, 220, 255));
        urlLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        JTextField urlField = new JTextField("https://example.com");
        urlField.setBackground(new Color(30, 30, 30));
        urlField.setForeground(Color.GRAY);
        urlField.setCaretColor(Color.WHITE);
        urlField.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));

        urlField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                urlField.setBorder(BorderFactory.createLineBorder(new Color(0,220,255),2));
                if (urlField.getText().equals("https://example.com")) {
                    urlField.setText("");
                    urlField.setForeground(Color.WHITE);
                }
            }
            public void focusLost(FocusEvent e) {
                urlField.setBorder(BorderFactory.createEmptyBorder(8,10,8,10));
                if (urlField.getText().isEmpty()) {
                    urlField.setText("https://example.com");
                    urlField.setForeground(Color.GRAY);
                }
            }
        });

        progressBar = new GlowProgressBar();
        progressBar.setPreferredSize(new Dimension(0, 8));
        progressBar.setVisible(false);

        inputSection.add(urlLabel, BorderLayout.NORTH);
        inputSection.add(urlField, BorderLayout.CENTER);
        inputSection.add(progressBar, BorderLayout.SOUTH);

        // ===== RESULT SECTION =====
        JPanel resultSection = new JPanel(new BorderLayout(10,10));
        resultSection.setBackground(new Color(255,255,255,25));
        resultSection.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel resultLabel = new JLabel("SCAN RESULT");
        resultLabel.setForeground(new Color(0, 220, 255));
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));

        resultArea = new JTextArea("Ready to scan...");
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(20,20,20));
        resultArea.setForeground(new Color(0,255,150));
        resultArea.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        resultArea.setLineWrap(true);

        JScrollPane scroll = new JScrollPane(resultArea);

        resultSection.add(resultLabel, BorderLayout.NORTH);
        resultSection.add(scroll, BorderLayout.CENTER);

        // ===== BUTTONS =====
        JPanel buttons = new JPanel();
        buttons.setOpaque(false);

        analyzeBtn = new JButton("Analyze");
        JButton clearBtn = new JButton("Clear");

        buttons.add(analyzeBtn);
        buttons.add(clearBtn);

        JPanel centerWrap = new JPanel(new BorderLayout(20,20));
        centerWrap.setOpaque(false);
        centerWrap.add(inputSection, BorderLayout.NORTH);
        centerWrap.add(resultSection, BorderLayout.CENTER);

        mainPanel.add(centerWrap, BorderLayout.CENTER);

        // ===== FOOTER + BUTTONS =====
        JPanel bottomSection = new JPanel(new BorderLayout());
        bottomSection.setOpaque(false);

        bottomSection.add(buttons, BorderLayout.NORTH);

        JLabel footer = new JLabel("Developed by Mrityunjay  |  Cybersecurity Project v1.0", JLabel.CENTER);
        footer.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        footer.setForeground(new Color(150,150,150));
        footer.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        bottomSection.add(footer, BorderLayout.SOUTH);

        mainPanel.add(bottomSection, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);

        // ===== ENTER KEY =====
        urlField.addActionListener(e -> analyzeBtn.doClick());

        // ===== ANALYZE =====
        analyzeBtn.addActionListener(e -> {

            String url = urlField.getText().trim();
            if (url.isEmpty() || url.equals("https://example.com")) {
                resultArea.setText("❌ Please enter valid URL.");
                resultArea.setForeground(Color.RED);
                return;
            }

            analyzeBtn.setEnabled(false);
            progressBar.setProgress(0);
            progressBar.setVisible(true);
            resultArea.setText("Scanning...");
            resultArea.setForeground(Color.WHITE);

            animateShield();

            Timer scanTimer = new Timer(12, null);
            scanTimer.addActionListener(new ActionListener() {
                int value = 0;
                public void actionPerformed(ActionEvent ev) {
                    value++;
                    progressBar.setProgress(value);
                    if (value >= 100) {
                        scanTimer.stop();
                        progressBar.setVisible(false);
                        showResult(analyzeURL(url));
                        analyzeBtn.setEnabled(true);
                    }
                }
            });
            scanTimer.start();
        });

        clearBtn.addActionListener(e -> {
            resultArea.setText("Ready to scan...");
            resultArea.setForeground(new Color(0,255,150));
            progressBar.setVisible(false);
        });
    }

    private static void animateShield() {
        Timer pulse = new Timer(150, null);
        pulse.addActionListener(new ActionListener() {
            int count=0;
            public void actionPerformed(ActionEvent e){
                shieldLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN,
                        (count%2==0)?34:28));
                count++;
                if(count>8) pulse.stop();
            }
        });
        pulse.start();
    }

    private static void showResult(String verdict){
        resultArea.setText("");
        Timer typing = new Timer(15,null);
        typing.addActionListener(new ActionListener(){
            int i=0;
            public void actionPerformed(ActionEvent e){
                if(i<verdict.length()){
                    resultArea.append(String.valueOf(verdict.charAt(i)));
                    i++;
                } else {
                    typing.stop();
                }
            }
        });
        typing.start();
    }

    public static String analyzeURL(String url){
        int risk = 0;
        StringBuilder reasons = new StringBuilder();

        try{
            URI uri = new URI(url);

            if(!url.startsWith("https://")){
                risk += 30;
                reasons.append("- Missing HTTPS\n");
            }

            if(url.contains("@")){
                risk += 25;
                reasons.append("- Contains '@' symbol\n");
            }

            if(uri.getHost()!=null &&
               uri.getHost().matches("\\d+\\.\\d+\\.\\d+\\.\\d+")){
                risk += 40;
                reasons.append("- Uses IP address instead of domain\n");
            }

        }catch(Exception e){
            return "❌ Invalid URL format";
        }

        if(risk >= 60)
            return "❌ HIGH RISK (" + risk + "%)\n\n" + reasons;
        else if(risk >= 30)
            return "⚠️ SUSPICIOUS (" + risk + "%)\n\n" + reasons;
        else
            return "✅ SAFE (" + risk + "%)\n\nNo major issues detected.";
    }
}

class GlowProgressBar extends JPanel{
    private int progress=0;
    public void setProgress(int v){progress=v; repaint();}
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;
        int w=getWidth(),h=getHeight();
        g2.setColor(new Color(50,50,50));
        g2.fillRoundRect(0,0,w,h,10,10);
        int fill=(int)(w*(progress/100.0));
        g2.setColor(new Color(0,200,255));
        g2.fillRoundRect(0,0,fill,h,10,10);
    }
}

class CoolBackgroundPanel extends JPanel {

    private float shift1 = 0f;
    private float shift2 = 0f;

    public CoolBackgroundPanel() {
        Timer timer = new Timer(40, e -> {
            shift1 += 0.0008f;
            shift2 += 0.0005f;
            if (shift1 > 1f) shift1 = 0f;
            if (shift2 > 1f) shift2 = 0f;
            repaint();
        });
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        int w = getWidth();
        int h = getHeight();

        g2.setColor(new Color(14, 18, 28));
        g2.fillRect(0, 0, w, h);

        RadialGradientPaint blob1 = new RadialGradientPaint(
                new Point((int)(w*(0.2+shift1)), (int)(h*0.3)),
                w/1.5f,
                new float[]{0f,1f},
                new Color[]{ new Color(0,200,255,70),
                             new Color(0,0,0,0)});
        g2.setPaint(blob1);
        g2.fillRect(0,0,w,h);

        RadialGradientPaint blob2 = new RadialGradientPaint(
                new Point((int)(w*(0.7-shift2)), (int)(h*0.7)),
                w/1.3f,
                new float[]{0f,1f},
                new Color[]{ new Color(0,120,255,60),
                             new Color(0,0,0,0)});
        g2.setPaint(blob2);
        g2.fillRect(0,0,w,h);

        RadialGradientPaint blob3 = new RadialGradientPaint(
                new Point((int)(w*(0.6 - shift1/2)), (int)(h*0.5)),
                w/2f,
                new float[]{0f,1f},
                new Color[]{ new Color(170,60,255,90),
                             new Color(0,0,0,0)});
        g2.setPaint(blob3);
        g2.fillRect(0,0,w,h);
    }
}
