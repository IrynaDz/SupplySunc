@Regression
@TariffsTag
Feature: verify creating tariffs
  Scenario: user can create new tariff
    Given login to the site
    When navigate to the tariffs page
    And click on create tariff
    And fill out all tariffs fields
    And click on button create
    Then verify user create new tariff
