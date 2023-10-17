@Regression
@BranchesTag
Feature: verify creating new branch
  Scenario: user can create new branch
    Given navigate to site
    When navigate to the branches page
    And click on create branch button
    And fill all inputs
    And click on button create branch
    Then verify user create new branch







