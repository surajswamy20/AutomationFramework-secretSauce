# Selenium Java Automation Framework

## Overview

This project is a robust Selenium Automation Framework developed using Java, Selenium WebDriver, TestNG, Maven, and the Page Object Model (POM). The framework is designed to automate web application testing with a focus on maintainability, scalability, and ease of execution.

It follows industry-standard automation practices by separating test logic from page objects, supporting reusable components, and integrating reporting, version control, and Continuous Integration.

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
* Listener Implementation using TestNG
* Driver Factory for Browser Initialization
* Reusable Utility Classes
* Data Driven Support using TestNG DataProvider
* Jenkins Continuous Integration
* Git Version Control
* Modular and Scalable Project Structure

---

## Project Structure

```
test1
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages
│   │   │   ├── utilities
│   │   │   └── base
│   │
│   └── test
│       └── java
│           └── tests
│
├── reports
│
├── screenshots
│
├── testng.xml
│
├── pom.xml
│
└── README.md
```

---

## Design Pattern

The framework follows the **Page Object Model (POM)**.

Each web page is represented as a separate Java class containing:

* Web Elements
* Page Actions
* Navigation Methods

This improves:

* Code Reusability
* Maintainability
* Readability
* Easy Object Repository Management

---

## Reporting

The framework generates professional HTML reports using **Extent Reports**.

Reports include:

* Test Name
* Pass / Fail Status
* Execution Details
* Failure Reason
* Execution Time
* Screenshots

Reports are automatically generated after execution.

---

## Screenshot Capture

The framework captures screenshots during execution using Selenium's `TakesScreenshot` interface.

Screenshots are stored inside the project directory and can be attached to reports for easier debugging.

---

## Test Execution

Tests can be executed using:

### TestNG

```
Run As → TestNG Test
```

### Maven

```
mvn clean test
```

### Jenkins

```
Build Now
```

---

## Continuous Integration (CI)

The framework is integrated with Jenkins.

Execution flow:

```
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
Clone Repository
        │
        ▼
Maven Build
        │
        ▼
Execute TestNG Tests
        │
        ▼
Generate Extent Report
        │
        ▼
Build Result
```

---

## Version Control

The project is maintained using Git.

Typical workflow:

```
git add .

git commit -m "Commit Message"

git push origin main
```

---

## Current Framework Components

* DriverFactory
* Base Utility Classes
* Page Classes
* Test Classes
* TestNG Listeners
* Extent Report Integration
* Screenshot Utility
* Maven Build Configuration
* Jenkins CI Integration

---

## Future Enhancements

* Config.properties Support
* ConfigReader Utility
* Log4j Logging
* Browser Selection through Jenkins Parameters
* Parallel Test Execution
* Selenium Grid Integration
* Docker Support
* Email Notifications
* Slack Notifications
* Retry Analyzer
* Database Validation
* API Automation Integration
* GitHub Webhook Trigger
* Jenkins Pipeline (Jenkinsfile)

---

## Author

**Suraj Basavaraj Swamy**

QA Automation Engineer

Skills:

* Selenium WebDriver
* Java
* TestNG
* Maven
* Jenkins
* Git & GitHub
* Page Object Model
* Automation Testing
* Manual Testing
* CI/CD
