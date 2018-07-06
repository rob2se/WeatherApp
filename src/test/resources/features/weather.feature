Feature: Weather
  The purpose of this feature is to test functionality of the weather site


  Scenario: Ensure city field defaults to Glasgow
    When The weather app launches
    Then The city field should default to Glasgow

  Scenario: Ensure app displays five day forecast
    When The weather app launches
    Then A five day forecast is displayed

  Scenario: Ensure a warning message is displayed if no city is entered on submit
    When The user deletes the contents of the city field
    And Submits form
    Then A warning message should be displayed

  Scenario: Ensure a warning message is displayed if an unknown city is entered
    When The user enters an unknown city
    Then A warning message should be displayed

  Scenario: Ensure days can be expanded to show more details
    When I expand a day
    Then A three hourly forecast is displayed
