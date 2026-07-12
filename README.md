# Selenium Java Automation Framework

## Overview

This project is a robust Selenium Automation Framework developed using **Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM)**. The framework is designed to automate web application testing with a focus on maintainability, scalability, and ease of execution.

It follows industry-standard automation practices by separating test logic from page objects, supporting reusable components, and integrating reporting, version control, and Continuous Integration.

---

# Application Under Test (AUT)

The automation framework is developed and executed against the **SauceDemo** web application.

**Application URL:**
https://www.saucedemo.com/

### Functional Modules Automated

* Login
* Product Listing
* Product Selection
* Shopping Cart
* Checkout Flow
* Logout (if implemented)

---

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* Page Object Model (POM)
* Extent Reports
* Apache Commons IO
* Git & GitHub
* Jenkins

---

## Framework Features

* Page Object Model (POM) Design Pattern
* Selenium WebDriver Automation
* TestNG Test Execution
* Cross Browser Support (Chrome, Firefox, Edge)
* Maven Dependency Management
* Extent HTML Reporting
* Screenshot Capture on Test Execution
* TestNG Listener Implementation
* Driver Factory for Browser Initialization
* Reusable Utility Classes
* Data-Driven Testing using TestNG DataProvider
* Jenkins Continuous Integration
* Git Version Control
* Modular and Scalable Project Structure

---

## Project Structure

```text
test1
│
├── src
│   ├── main
│   │   └── java
│   │       ├── base
│   │       ├── pages
│   │       └── utilities
│   │
│   └── test
│       └── java
│           └── tests
│
├── reports
├── screenshots
├── testng.xml
├── pom.xml
└── README.md
```

---

## Design Pattern

The framework follows the **Page Object Model (POM)** design pattern.

Each web page is represented as a separate Java class containing:

* Web Elements (Locators)
* Page Actions
* Navigation Methods

### Benefits

* High Code Reusability
* Easy Maintenance
* Better Readability
* Separation of Test Logic and UI Elements

---

## Reporting

The framework generates interactive HTML reports using **Extent Reports**.

The report includes:

* Test Name
* Pass/Fail Status
* Execution Time
* Exception Details
* Test Logs
* Screenshots (where implemented)

Reports are automatically generated after every execution.

---

## Screenshot Capture

The framework captures screenshots using Selenium's **TakesScreenshot** interface.

Screenshots are generated during execution and stored inside the project directory for easier debugging and reporting.

---

## Test Execution

Tests can be executed using:

### TestNG

```bash
Run As → TestNG Test
```

### Maven

```bash
mvn clean test
```

### Jenkins

```text
Build Now
```

---

## Continuous Integration (CI)

The framework is integrated with Jenkins for automated test execution.

### CI Workflow

```text
Developer / Tester
        │
        ▼
Git Commit
        │
        ▼
Git Push
        │
        ▼
GitHub Repository
        │
        ▼
Jenkins
        │
        ▼
Clone Latest Code
        │
        ▼
Maven Build
        │
        ▼
Execute TestNG Test Suite
        │
        ▼
Generate Extent Report
        │
        ▼
Build Success / Failure
```

---

## Version Control

Git is used for source code management.

Typical workflow:

```bash
git add .
git commit -m "Commit Message"
git push origin main
```

---

## Current Framework Components

* DriverFactory
* Base Utility Classes
* Page Object Model (POM)
* Test Classes
* TestNG Listeners
* Extent Report Integration
* Screenshot Utility
* Maven Build Configuration
* Jenkins Integration

---

## Future Enhancements

* Config.properties Support
* ConfigReader Utility
* Log4j2 Logging
* Browser Selection using Jenkins Parameters
* Parallel Test Execution
* Selenium Grid Integration
* Docker Support
* Retry Analyzer
* Email Notifications
* Slack Notifications
* Database Validation
* API Automation Integration
* GitHub Webhook Trigger
* Jenkins Pipeline (Jenkinsfile)

---

## Author

**Suraj Basavaraj Swamy**

**QA Automation Engineer**

### Technical Skills

* Selenium WebDriver
* Java
* TestNG
* Maven
* Jenkins
* Git & GitHub
* Page Object Model (POM)
* Manual Testing
* Automation Testing
* CI/CD
