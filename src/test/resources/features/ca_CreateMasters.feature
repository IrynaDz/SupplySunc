@Regression
Feature: create masters
  Background:
    Given user navigates to the login page
    When user logs in with valid credentials
    Then user clicks on masters
    And user clicks on create master button

    @Positive
    Scenario: user should be able to create master
      When user fill out all fields
      And user chooses branch
      When user clicks on create button
      Then verify created master exists and user sees positive message

      @Negative
    Scenario Outline: user shouldn't be able to create master
      When user fills out "<name>", "<last name>", "<email>", "<password>", "<place of residence>", "<phone number>"
      And user chooses branch
      Then user clicks on create button
      Then verify user can't see the page with created masters
      Examples:
        | name    | last name | email             | password  | place of residence | phone number |
        | Peter   | Pan       | pangmail.com      | 1234567   | Neverland          | 787364783    |
        |         | Jobs      | steve@gmail.com   | 2762667   | Tortuga            | 678909876    |
        | Bill    |           | bill@gmail.com    | 4388348   | LA                 | 787654567    |
        | Elon    | Musk      | elon@gmail.com    |           | California         | 098765432    |
        | Damon   | Salvatore | damon@gmail.com   | 373477487 |                    | 345678765    |
        | Michael | Scofield  | michael@gmail.com | 238333889 | Fox River          |              |