@MastersTag
Feature: verify a branch from Masters is deleted
  @CancelDeletingBranchFromMasters
  Scenario: user can cancel deleting a branch from Masters
    Given login to the home page with valid credentials
    When navigate to Masters option and click on it
    And click on three dots on bottom right of the branch
    And click on Delete from drop down
    And click on Cancel button
    Then verify user was able to cancel deleting a branch from Masters and branch is still in Masters

  @DeleteBranchFromMasters
  Scenario: user can delete a branch from Masters
    Given login to the home page with valid credentials
    When navigate to Masters option and click on it
    And click on three dots on bottom right of the branch
    And click on Delete from drop down
    And click on Delete red button
    Then verify user was able to delete a branch from Masters


