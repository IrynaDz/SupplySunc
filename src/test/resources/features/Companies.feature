@CompaniesTag
Feature: verify editing new information of companies
  @Happy_path
  Scenario: user can edit information of companies
    Given login to the site
    When navigate to the company page
    And click on edit
    And fill out all fields
    And click on button save
    Then verify user edit company information

  @EmptyInformationTag
  Scenario: user can not left empty field of company name
    Given login to the site
    When navigate to the company page
    And click on edit
    Then empty the company name field
    And click on button save
    Then verify user cann't save information with empty name field

    @EmptyInformationTag
  Scenario: user can not left empty field of company email
    Given login to the site
    When navigate to the company page
    And click on edit
    Then empty the company email field
    And click on button save
    Then verify user cann't save information with empty email field

  @EmptyInformationTag
  Scenario: user can not left empty field of company address
    Given login to the site
    When navigate to the company page
    And click on edit
    Then empty the company address field
    And click on button save
    Then verify user cann't save information with empty address field

  @EmptyInformationTag
  Scenario: user can not left empty field of company phone number
    Given login to the site
    When navigate to the company page
    And click on edit
    Then empty the company phone number field
    And click on button save
    Then verify user cann't save information with empty phone number field


