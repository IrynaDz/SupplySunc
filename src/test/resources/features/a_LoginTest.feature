@Regression
@login
Feature: login functionality

  Background:
    Given the user on the login page

  @loginPositiveScenario
  Scenario: the user should be to login with valid credentials
    When the user enters valid username "admin@codewise.com"
    And the user enters valid password "codewise123"
    And the user clicks on signIn button
    Then the user should see the main page

  @loginNegativeScenario
  Scenario Outline: the user should see the error message when he enters invalid credentials
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks on signIn button
    Then the user should see the error message
    Examples:
      | username           | password    |
      | admin@codewise.com | codewiseeee |
      | user@codewise.com  | codewise123 |
      | admin@gmail.com    | codewise123 |
      | admincodewise.com  | codewise123 |
      | ADMIN@CODEWISE.COM | CODEWISE123 |