@Regression
@TariffsTag
Feature: verify functionality with tariffs

  Background:
    Given login to the site
    When navigate to the tariffs page

  @CreatingTariffsTag
  Scenario: user can create new tariff

    And click on create tariff
    And fill out all tariffs fields
    And click on button create
    Then verify user create new tariff

  @DeletingTariffsTag
    Scenario:user can delete tariff
      And click on row of tariffs
      And hover over to dot's menu and click
      And choose delete button
      And confirm deleting
      Then verify user was able delete tariff





