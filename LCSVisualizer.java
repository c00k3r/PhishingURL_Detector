import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public class LCSVisualizer extends JFrame {

    JTextField inputX, inputY;
    JButton startButton, resetButton;
    JTable table1, table2;
    JLabel resultLabel;

    int[][] dp;
    boolean[][] path;

    public LCSVisualizer() {
        setTitle("Longest Common Subsequence Visualizer");
        setSize(1050, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // 🔹 Top Panel
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        inputX = new JTextField(12);
        inputY = new JTextField(12);

        startButton = new JButton("Start Algorithm");
        resetButton = new JButton("Reset");

        topPanel.add(new JLabel("String X: "));
        topPanel.add(inputX);
        topPanel.add(new JLabel("String Y: "));
        topPanel.add(inputY);
        topPanel.add(startButton);
        topPanel.add(resetButton);

        add(topPanel, BorderLayout.NORTH);

        // 🔹 Center Panel
        JPanel centerPanel = new JPanel(new GridLayout(1,2,15,15));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        table1 = new JTable();
        table2 = new JTable();

        centerPanel.add(new JScrollPane(table1));
        centerPanel.add(new JScrollPane(table2));

        add(centerPanel, BorderLayout.CENTER);

        // 🔹 Bottom Panel
        JPanel bottomPanel = new JPanel();
        resultLabel = new JLabel("LCS: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bottomPanel.add(resultLabel);

        add(bottomPanel, BorderLayout.SOUTH);

        // Button Actions
        startButton.addActionListener(e -> runLCS());
        resetButton.addActionListener(e -> resetAll());

        setVisible(true);
    }

    private void runLCS() {
        String X = inputX.getText();
        String Y = inputY.getText();

        int m = X.length();
        int n = Y.length();

        dp = new int[m + 1][n + 1];
        String[][] dir = new String[m + 1][n + 1];
        path = new boolean[m + 1][n + 1];

        // 🔹 Fill DP + Direction
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    dir[i][j] = "↖";
                } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    dir[i][j] = "↑";
                } else {
                    dp[i][j] = dp[i][j - 1];
                    dir[i][j] = "←";
                }
            }
        }

        // 🔹 Backtracking (mark path)
        int i = m, j = n;
        StringBuilder lcs = new StringBuilder();

        while (i > 0 && j > 0) {
            path[i][j] = true;

            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.append(X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        path[0][0] = true;

        resultLabel.setText("LCS: " + lcs.reverse().toString());

        // 🔹 Table 1
        String[][] data1 = new String[m + 1][n + 1];
        String[] cols = new String[n + 1];

        cols[0] = "";
        for (int c = 1; c <= n; c++) {
            cols[c] = String.valueOf(Y.charAt(c - 1));
        }

        for (int r = 0; r <= m; r++) {
            for (int c = 0; c <= n; c++) {
                data1[r][c] = String.valueOf(dp[r][c]);
            }
        }

        table1.setModel(new DefaultTableModel(data1, cols));
        table1.setRowHeight(35);

        table1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int col) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                if (path[row][col]) c.setBackground(Color.YELLOW);
                else c.setBackground(Color.WHITE);

                setHorizontalAlignment(CENTER);
                return c;
            }
        });

        // 🔹 Table 2
        String[][] data2 = new String[m + 1][n + 1];

        for (int r = 0; r <= m; r++) {
            for (int c = 0; c <= n; c++) {
                if (r == 0 || c == 0) data2[r][c] = "";
                else data2[r][c] = dir[r][c];
            }
        }

        table2.setModel(new DefaultTableModel(data2, cols));
        table2.setRowHeight(35);

        table2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                           boolean isSelected, boolean hasFocus,
                                                           int row, int col) {

                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

                if (path[row][col]) c.setBackground(Color.YELLOW);
                else c.setBackground(Color.WHITE);

                setHorizontalAlignment(CENTER);
                setFont(new Font("Segoe UI Symbol", Font.BOLD, 18));
                return c;
            }
        });
    }

    private void resetAll() {
        inputX.setText("");
        inputY.setText("");

        table1.setModel(new DefaultTableModel());
        table2.setModel(new DefaultTableModel());

        resultLabel.setText("LCS: ");

        dp = null;
        path = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LCSVisualizer::new);
    }
}