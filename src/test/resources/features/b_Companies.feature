@Regression
@CompaniesTag
Feature: verify editing new information of companies

  Background:
    Given login to the site
    When navigate to the company page
    And click on edit

  @Happy_path
  Scenario: user can edit information of companies
    And fill out all fields
    And click on button save
    Then verify user edit company information

  @EmptyInformationTag
  Scenario: user can not left empty field of company name
    Then empty the company name field
    And click on button save
    Then verify user cann't save information with empty name field

    @EmptyInformationTag
  Scenario: user can not left empty field of company email
    Then empty the company email field
    And click on button save
    Then verify user cann't save information with empty email field

  @EmptyInformationTag
  Scenario: user can not left empty field of company address
    Then empty the company address field
    And click on button save
    Then verify user cann't save information with empty address field

  @EmptyInformationTag
  Scenario: user can not left empty field of company phone number
    Then empty the company phone number field
    And click on button save
    Then verify user cann't save information with empty phone number field


