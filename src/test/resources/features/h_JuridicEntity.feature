@Regression
Feature: Verify user can create new Juridic Legal Entity

  @JuridicEntityTag
  Scenario: user can create new Legal Entity
    Given  Given login to the site
    When navigate to the Juridic Entity page
    And click on create Legal Entity
    And fill out all fields in box
    And click on button create Legal Entity
    Then verify user create new Legal Entity
