# Simple Test Automation Framework
The project provides the design of a simple test framework and a series of test scenarios that cover requirements using BDD.
The requirement which was covered says “As a User I want to go to Weather.com website and search for the weather forecast in a few cities.”
Framework provides ability to run tests in Chrome, FF, IE browsers

## Project structure:
* Feature files - where described tests in descriptive language
* Step definitions - maps the Test Case Steps in the feature file to code.
* Steps - intermediate layer for interaction between Step Definitions and Page Objects
* Page Objects - classes that serves as an interface to a page
* Runners - sets up the test and records the test results

## Tools
  - **Junit** simple framework to write repeatable tests. It is an instance of the xUnit architecture for unit testing frameworks.
  - **Serenity BDD Framework** Serenity BDD helps you write cleaner and more maintainable automated acceptance and regression tests
  - **Cucumber** is an open-source tool based on Behavior Driven Development (BDD) framework which is used to write acceptance tests for the web application.
  - **Gradle** is an open-source build automation tool focused on flexibility and performance.

#### Example of feature:
```
@driver:chrome
Feature: As a User I want to go to Weather.com website and search for the weather forecast in a few cities.

  @SmokeSuite @RegressionSuite
  Scenario Outline: Searching for the weather forecast in a few cities.
    Given I am on Weather.com home page
    When I search the weather forecast for city by name <city>
    And I select the city <city> from the dropdown
    Then I see the weather forecast for city <city>

  Examples:
    |city      |
    |Paris     |
    |Amsterdam |
```

#### Example of Runner class:
```
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        tags = {"@SmokeSuite"}
)
public class SmokeTestSuite {
}
```
## How to execute
1. Clone project
2. Setup the driver with using of @driver in feature file (chrome, firefox, ie)
3. Run gradle.build file. Serenity will provide the report index.html located in target/site/serenity
4. Or run test suites with runners from test/java/adi/ package

**Additional settings**
You can set additional parameters in serenity.conf file:
- webdriver.timeouts.implicitlywait;
- headless.mode;
- chrome.switches, etc;