# 🧪 Selenium Java Automation Framework — Sauce Demo

![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=flat)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![Jenkins](https://img.shields.io/badge/CI-Jenkins-D24939?style=flat&logo=jenkins&logoColor=white)
![Extent Reports](https://img.shields.io/badge/Reports-Extent-blueviolet?style=flat)

## Overview

This project is a robust Selenium Automation Framework developed using **Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM)**. The framework is designed to automate web application testing with a focus on maintainability, scalability, and ease of execution.

It follows industry-standard automation practices by separating test logic from page objects, supporting reusable components, and integrating reporting, version control, and Continuous Integration.

---

## Application Under Test (AUT)

The automation framework is developed and executed against the **SauceDemo** web application.

**Application URL:** https://www.saucedemo.com/

### Functional Modules Automated
* Login
* Product Listing
* Product Selection
* Shopping Cart
* Checkout Flow
* Logout

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Extent Reports
* Apache Commons IO / Apache POI (Excel data)
* Git & GitHub
* Jenkins

---

## Framework Features

* Page Object Model (POM) design pattern
* Selenium WebDriver automation
* TestNG test execution & suite management (`testng.xml`)
* Cross-browser support (Chrome, Firefox, Edge) — separate report per browser
* Maven dependency management & build
* Extent / HTML reporting
* Screenshot capture on test failure
* Custom TestNG Listener implementation
* Driver Factory for browser initialization
* **Retry Analyzer** for automatic re-run of flaky tests
* Reusable utility classes
* Data-driven testing (TestNG DataProvider + Excel workbook)
* Jenkins Continuous Integration (`Jenkinsfile`)
* Git version control
* Modular and scalable project structure

---

## Project Structure

```text
AutomationFramework-secretSauce
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base          # resorces, setup_teardown_utility (config + base setup/teardown)
│   │       ├── pages         # loginPage, product, cart          (Page Objects)
│   │       └── utilities     # driverfactory, implementationOfListeners,
│   │                         # RetryAnalyser, RetryListener       (framework core)
│   └── test
│       └── java
│           └── tests         # LoginPageTest, ProductTest, cartTest
│
├── data_from sheet           # Workbook1.xlsx  (data-driven inputs)
├── reports                   # chrome / firefox / edge run reports
├── test-output               # TestNG output + emailable-report.html
├── testng.xml                # suite definition
├── pom.xml                   # dependencies & build
├── Jenkinsfile               # CI pipeline
└── README.md
```

---

## Design Pattern

The framework follows the **Page Object Model (POM)** design pattern. Each web page is represented as a separate Java class containing:

* Web elements (locators)
* Page actions
* Navigation methods

### Benefits
* High code reusability
* Easy maintenance
* Better readability
* Separation of test logic and UI elements

---

## Reporting

The framework generates interactive HTML reports using **Extent Reports**. Each report includes:

* Test name
* Pass / Fail status
* Execution time
* Exception details
* Test logs
* Screenshots (on failure)

Per-browser reports are stored in `reports/` (`chrome_reprot.html`, `firefox_reprot.html`, `edge_reprot.html`) and TestNG output (including `emailable-report.html`) in `test-output/`. Reports are generated automatically after every execution.

---

## Screenshot Capture

Screenshots are captured via Selenium's **TakesScreenshot** interface, triggered automatically by the custom TestNG listener on failure, and stored in the project directory for easier debugging and reporting.

---

## Test Execution

**Prerequisites:** Java JDK 11+, Maven, and Chrome / Firefox / Edge installed.

```bash
# Clone
git clone https://github.com/surajswamy20/AutomationFramework-secretSauce.git
cd AutomationFramework-secretSauce
```

### TestNG (IDE)
```text
Run As → TestNG Test   (or run testng.xml)
```

### Maven
```bash
mvn clean test
mvn clean test -DsuiteXmlFile=testng.xml
```

### Jenkins
```text
Build Now
```

---

## Continuous Integration (CI)

The framework is integrated with Jenkins (`Jenkinsfile`) for automated test execution.

```text
Developer / Tester
        │  git commit → git push
        ▼
GitHub Repository
        │
        ▼
Jenkins  →  Clone latest code  →  Maven build  →  Execute TestNG suite
                                                          │
                                                          ▼
                                       Generate Extent Report → Build Success / Failure
```

---

## Version Control

Git is used for source code management.

```bash
git add .
git commit -m "Commit message"
git push origin main
```

---

## Current Framework Components

* DriverFactory
* Base utility classes (setup / teardown)
* Page Object Model (POM)
* Test classes (Login, Product, Cart)
* Custom TestNG Listeners
* Retry Analyzer (flaky-test re-run)
* Extent report integration
* Screenshot utility
* Data-driven testing (Excel + DataProvider)
* Maven build configuration
* Jenkins integration (Jenkinsfile)

---

## Future Enhancements

* `config.properties` + ConfigReader utility
* Log4j2 logging
* Browser selection via Jenkins parameters
* Parallel test execution
* Selenium Grid integration
* Docker support
* Email / Slack notifications
* Database validation
* REST Assured API automation integration
* GitHub Actions / webhook-triggered pipeline

---

## Author

**Suraj Basavaraj Swamy** — QA Automation Engineer / SDET

📫 soorajswaamy@gmail.com · [LinkedIn](https://linkedin.com/in/suraj-swamy-254292217) · [GitHub](https://github.com/surajswamy20)

### Technical Skills
Selenium WebDriver · Java · TestNG · Maven · Jenkins · Git & GitHub · Page Object Model · Data-Driven Testing · Cross-Browser Testing · CI/CD · Manual & Automation Testing · Postman · JIRA · TestRail
