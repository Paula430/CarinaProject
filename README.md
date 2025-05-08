# Test Automation with Carina framework

A test automation framework combining API, Web UI, and Data-Driven tests using [Carina Framework](http://zebrunner.github.io/carina/).

## Features

- **API Testing**: RESTful services validation with schema verification
- **Web Testing**: Browser-based UI testing with Page Object Model
- **Data-Driven Testing**:
    - Inline DataProviders for simple parameterization
    - Excel-based parameterization for complex scenarios

## Technology Stack

- **Framework**: [Carina](https://github.com/zebrunner/carina)
- **Language**: Java 11+
- **Build Tool**: Maven

## Project Structure

```text
├── src
│   └── main                            #Page Object classes, API domains etc
│       ├── groovy
│       └── java
│           └── com.solvd.carina.demo
│               ├── api
│               ├── db
│               └── gui
│                   ├── components
│                   │   └── automation
│                   ├── compare
│                   ├── footer
│                   └── pages.automation
├── resources                           #configuration properties files
├── test
│   ├── java                            #Test classes
│   │   └── com.solvd.carina.demo
│   │       ├── regression
│   │       ├── APITest
│   │       ├── AutomationWebTest
│   │       └── MyDataProvider
│   └── resources                       #XML files, API templates and XLS data providers etc.
│       ├── api.carts
│       ├── data_source
│       ├── features
│       ├── images
│       └── testing_suites

```
### Getting started
* Install and configure JDK 11
* Install and configure [Apache Maven 3.6.0+](http://maven.apache.org/)
* Download and start the latest [Selenium standalone server](http://www.seleniumhq.org/download/)

### Run tests
```
mvn clean test -Dsuite=[nameOfSuite]
```

