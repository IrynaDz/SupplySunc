@Regression
  @Logout
Feature: logout functionality

  Background:
    Given the user on the login page

  @loginPositiveScenario
  Scenario: the user should be able to logout from webpage
    When the user login to the web page with valid credentials
    And the user navigate to Administrator and click on it
    And the user click on Exit button
    And the user click on Exit red button
    Then verify user was able to logout
