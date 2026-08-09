# 🛡️ Phishing URL Detector

A lightweight **Java-based desktop application for detecting potentially malicious and suspicious URLs** using rule-based security analysis.

The application provides a modern graphical interface where users can enter a URL and receive an immediate risk assessment based on common phishing indicators such as insecure connections, IP-based URLs, and suspicious `@` characters.

> ⚠️ **Educational Project:** This tool is designed for cybersecurity learning and demonstration purposes. It should not be treated as a replacement for professional threat-intelligence platforms, browser security mechanisms, or enterprise-grade phishing detection systems.

---

## 🚀 Features

* 🔍 **URL Risk Analysis**

  * Analyzes submitted URLs for common phishing indicators.
* 🔐 **HTTPS Verification**

  * Flags URLs that do not use HTTPS.
* 🌐 **IP Address Detection**

  * Identifies URLs using an IP address instead of a conventional domain name.
* ⚠️ **Suspicious Character Detection**

  * Detects the use of the `@` symbol, which can be abused to disguise the actual destination of a URL.
* 📊 **Risk Scoring**

  * Assigns a numerical risk score based on detected indicators.
* 🟢 **Three-Level Verdict**

  * `SAFE`
  * `SUSPICIOUS`
  * `HIGH RISK`
* 🖥️ **Graphical User Interface**

  * Built using Java Swing.
* ⚡ **Interactive Scanning UI**

  * Includes a scanning progress animation and animated security-shield indicator.
* 🧹 **Clear & Rescan**

  * Allows users to quickly reset the interface and analyze another URL.

---

## 🧠 How It Works

The detector uses a **rule-based scoring mechanism** rather than machine learning.

When a URL is submitted, the application parses it and checks for several security indicators.

### 1. HTTPS Check

URLs that do not begin with `https://` receive a risk score increase.

```text
Missing HTTPS → +30 risk points
```

HTTPS alone does **not** guarantee that a website is legitimate, but the absence of HTTPS can be a useful warning indicator.

### 2. `@` Symbol Detection

The application checks whether the URL contains an `@` character.

```text
Contains @ → +25 risk points
```

The `@` character can sometimes be abused in URLs to make a malicious destination appear trustworthy.

### 3. IP Address Detection

The detector checks whether the URL's host is represented directly as an IPv4 address.

```text
IP address instead of domain → +40 risk points
```

For example:

```text
http://192.168.1.10/login
```

rather than:

```text
https://example.com/login
```

Using an IP address is not automatically malicious, but it can be a useful indicator when combined with other suspicious characteristics.

---

## 📊 Risk Classification

The final score determines the application's verdict:

| Risk Score | Verdict       | Meaning                                     |
| ---------: | ------------- | ------------------------------------------- |
|     `0–29` | 🟢 SAFE       | No major indicators detected                |
|    `30–59` | 🟡 SUSPICIOUS | One or more warning indicators detected     |
|      `60+` | 🔴 HIGH RISK  | Multiple or significant indicators detected |

### Example

A URL that:

* does not use HTTPS → `+30`
* contains an `@` symbol → `+25`

would receive:

```text
Risk Score = 55
Verdict = SUSPICIOUS
```

---

## 🏗️ Application Workflow

```text
                ┌───────────────────┐
                │   User enters URL │
                └─────────┬─────────┘
                          │
                          ▼
                ┌───────────────────┐
                │    Parse URL      │
                └─────────┬─────────┘
                          │
                          ▼
             ┌──────────────────────────┐
             │ Check security indicators│
             └────────────┬─────────────┘
                          │
          ┌───────────────┼────────────────┐
          │               │                │
          ▼               ▼                ▼
     HTTPS Check     @ Symbol Check   IP Address Check
          │               │                │
          └───────────────┼────────────────┘
                          ▼
                ┌───────────────────┐
                │ Calculate Risk    │
                │      Score        │
                └─────────┬─────────┘
                          │
                          ▼
             ┌────────────────────────┐
             │ Generate Final Verdict │
             └────────────┬───────────┘
                          │
              ┌───────────┼───────────┐
              ▼           ▼           ▼
            SAFE     SUSPICIOUS    HIGH RISK
```

---

## 🖥️ User Interface

The application uses **Java Swing** to provide a graphical cybersecurity-themed interface.

The interface includes:

* URL input field
* Analyze button
* Clear button
* Scan progress indicator
* Animated shield indicator
* Result display area
* Cybersecurity-themed dynamic background

The UI was designed to make the detection process easy to understand while maintaining a security-focused visual style.

---

## 🛠️ Tech Stack

| Technology              | Purpose                      |
| ----------------------- | ---------------------------- |
| **Java**                | Core programming language    |
| **Java Swing**          | Graphical user interface     |
| **Java AWT**            | UI rendering and graphics    |
| **Java URI API**        | URL parsing and validation   |
| **Rule-Based Analysis** | Phishing indicator detection |

---

## 📁 Project Structure

```text
PhishingURL_Detector/
│
├── PhishingDetectorGUI.java    # Main application and detection logic
├── .gitignore                   # Git ignored files
└── README.md                    # Project documentation
```

---

## ⚙️ Requirements

Before running the project, make sure you have:

* Java Development Kit (JDK)
* Java compiler (`javac`)
* Java Runtime Environment (`java`)

A modern JDK is recommended.

You can verify your Java installation using:

```bash
java -version
javac -version
```

---

## 🚀 Installation & Usage

### 1. Clone the repository

```bash
git clone https://github.com/c00k3r/PhishingURL_Detector.git
```

### 2. Navigate into the project

```bash
cd PhishingURL_Detector
```

### 3. Compile the application

```bash
javac PhishingDetectorGUI.java
```

### 4. Run the application

```bash
java PhishingDetectorGUI
```

### 5. Analyze a URL

Enter a URL into the application and click:

```text
Analyze
```

The application will calculate the risk score and display the corresponding verdict.

---

## 🔬 Example Analysis

### Example 1 — HTTPS URL

```text
https://example.com
```

Possible result:

```text
✅ SAFE (0%)

No major issues detected.
```

### Example 2 — Non-HTTPS URL

```text
http://example.com
```

Result:

```text
⚠️ SUSPICIOUS (30%)

- Missing HTTPS
```

### Example 3 — IP-Based URL

```text
http://192.168.1.100/login
```

Result:

```text
⚠️ SUSPICIOUS (70%)

- Missing HTTPS
- Uses IP address instead of domain
```

---

## 🔐 Security Considerations

This project demonstrates **static URL-based analysis**.

It does **not**:

* Visit or execute the submitted website
* Inspect webpage HTML or JavaScript
* Query real-time phishing databases
* Perform WHOIS/domain-age analysis
* Check DNS reputation
* Use machine learning
* Guarantee that a URL is safe

A legitimate website can potentially trigger one or more rules, while a sophisticated phishing URL may avoid them.

Therefore, the result should be interpreted as a **risk indicator**, not a definitive security verdict.

---

## 🔮 Future Improvements

This project can be extended into a more comprehensive phishing detection platform.

Potential improvements include:

### 🔎 Advanced URL Analysis

* URL length analysis
* Domain age analysis
* Subdomain analysis
* Suspicious keyword detection
* URL shortening detection
* Punycode/homograph attack detection
* Excessive special-character detection
* Redirect analysis

### 🌐 Threat Intelligence

Integration with services such as:

* Google Safe Browsing
* VirusTotal
* PhishTank
* URLhaus

could provide real-time reputation information.

### 🤖 Machine Learning

The rule-based detector could be extended using machine-learning models trained on phishing and legitimate URL datasets.

Potential models include:

* Logistic Regression
* Decision Trees
* Random Forest
* Support Vector Machines
* Gradient Boosting

### 🖥️ Application Improvements

* Browser extension integration
* Web-based interface
* REST API
* Detailed risk reports
* URL history
* Threat-intelligence dashboard
* Exportable scan reports

---

## 🎯 Learning Objectives

This project was developed as a practical cybersecurity project to explore:

* Phishing attack indicators
* URL structure and parsing
* Security-oriented rule design
* Risk scoring
* Java programming
* Java Swing GUI development
* Input validation
* Basic threat detection concepts

---

## ⚠️ Disclaimer

This project is intended **strictly for educational and defensive cybersecurity purposes**.

The detection mechanism is heuristic and should not be relied upon as a complete phishing protection system. A `SAFE` result does not guarantee that a website is trustworthy.

Always verify suspicious links through trusted sources and avoid entering sensitive information on unfamiliar websites.

---

## 👨‍💻 Author

**Mrityunjay**

Cybersecurity & Computer Science Student

Interested in:

* Cybersecurity
* VAPT
* Network Security
* Threat Detection
* Ethical Hacking
* Secure Software Development

---

## ⭐ Project Status

**Version:** `1.0`

**Status:** Educational / Prototype

The current implementation focuses on demonstrating fundamental rule-based phishing URL detection and a Java-based graphical interface.

---

## 📜 License

This project currently does not specify a formal open-source license.

If you intend to allow others to freely use, modify, and redistribute the project, consider adding an appropriate license such as the MIT License.
