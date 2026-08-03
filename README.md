# 🧪 Selenium Automation Framework — Sauce Demo

![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=openjdk&logoColor=white)
![Selenium](https://img.shields.io/badge/Selenium-43B02A?style=flat&logo=selenium&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-FF6C37?style=flat)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat&logo=apachemaven&logoColor=white)
![Jenkins](https://img.shields.io/badge/CI-Jenkins-D24939?style=flat&logo=jenkins&logoColor=white)

A scalable, **CI/CD-ready Selenium + Java** test automation framework built from scratch using the **Page Object Model**, **TestNG**, and **Maven**. Designed for reuse, easy onboarding of new suites, and clear reporting.

**Application Under Test:** [saucedemo.com](https://www.saucedemo.com)

---

## ✨ Features

- **Page Object Model (POM)** — clean separation of page logic (`loginPage`, `product`, `cart`) from tests
- **Reusable DriverFactory & Base layer** — add new tests without rewriting setup/teardown
- **Cross-browser execution** — Chrome, Firefox, and Edge (separate reports per browser)
- **Data-driven testing** — test data sourced from Excel (`data_from sheet/Workbook1.xlsx`)
- **Custom TestNG Listeners** — automatic logging + **screenshot capture on failure**
- **Retry mechanism** — `RetryAnalyser` + `RetryListener` auto-retry flaky tests
- **Rich reporting** — HTML/Extent-style reports (`reports/`, `test-output/`)
- **CI/CD ready** — `Jenkinsfile` for scheduled and on-demand runs

---

## 🛠️ Tech Stack

| Area | Tools |
|------|-------|
| Language | Java |
| Automation | Selenium WebDriver |
| Test Runner | TestNG |
| Build | Maven |
| Design | Page Object Model, DriverFactory, BaseTest |
| Reporting | Extent / TestNG HTML reports, screenshots |
| CI/CD | Jenkins |
| Data | Apache POI (Excel) |

---

## 📁 Project Structure

```
src/main/java/
├── base/          # resorces, setup_teardown_utility  (config + base setup/teardown)
├── pages/         # loginPage, product, cart          (Page Objects)
└── utilities/     # driverfactory, implementationOfListeners,
                   # RetryAnalyser, RetryListener       (framework core)
src/test/java/
└── tests/         # LoginPageTest, ProductTest, cartTest
data_from sheet/   # Workbook1.xlsx                     (data-driven inputs)
reports/           # chrome / firefox / edge run reports
testng.xml         # suite definition
pom.xml            # dependencies & build
Jenkinsfile        # CI pipeline
```

---

## 🚀 Getting Started

**Prerequisites:** Java JDK 11+, Maven, Chrome/Firefox/Edge

```bash
# clone
git clone https://github.com/surajswamy20/AutomationFramework-secretSauce.git
cd AutomationFramework-secretSauce

# run the full suite
mvn clean test

# run a specific TestNG suite
mvn clean test -DsuiteXmlFile=testng.xml
```

Reports are generated under `reports/` and `test-output/` after each run.

---

## 📊 Reports
- Per-browser HTML reports in `reports/` (`chrome_reprot.html`, `firefox_reprot.html`, `edge_reprot.html`)
- TestNG output + `emailable-report.html` in `test-output/`
- Failure screenshots captured automatically via the custom listener

---

## 🔁 CI/CD
The included `Jenkinsfile` runs `mvn clean test` on a Jenkins agent, so regression feedback reaches the team the same day. Extendable to GitHub Actions.

---

## 👤 Author
**Suraj Basavaraj Swamy** — QA Automation Engineer / SDET
[LinkedIn](https://linkedin.com/in/suraj-swamy-254292217) · soorajswaamy@gmail.com
