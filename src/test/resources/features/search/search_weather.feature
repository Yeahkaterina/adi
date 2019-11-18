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

  @SmokeSuite @RegressionSuite
  Scenario Outline: Searching for the weather forecast in a few cities using abbreviation.
    Given I am on Weather.com home page
    When I search the weather forecast for city by abbreviation <abbreviation>
    Then I see the list of cities with abbreviation <abbreviation>
    When I select the city by <location>
    Then I see the weather forecast for city <city>

    Examples:
      |abbreviation |location                                |city         |
      |NY           |New York, NY, UNITED STATES OF AMERICA  |New York     |
      |Chi          |Chicago, IL, UNITED STATES OF AMERICA   |Chicago      |


  @SmokeSuite @RegressionSuite
  Scenario Outline: Searching for the weather forecast in a few cities by incorrect query.
    Given I am on Weather.com home page
    When I search the weather forecast for city by name <text>
    Then I see the error message <error message>

    Examples:
      |text         |error message          |
      |123456789    |There was a problem    |
      |*&?          |There was a problem    |

  @RegressionSuite
  Scenario Outline: Searching for the weather forecast in a few cities at once.
    Given I am on Weather.com home page
    When I search the weather forecast for city by name <city1>
    And I select the city <city1> from the dropdown
    Then I see the weather forecast for city <city1>
    When I search the weather forecast for city by name <city2>
    And I select the city <city2> from the dropdown
    Then I see the weather forecast for city <city2>
    And I see selected cities in saved locations bar
      |London, England, United Kingdom |Prague, Prague, Czech Republic |

    Examples:
      |city1       |city2      |
      |Prague      |London     |








