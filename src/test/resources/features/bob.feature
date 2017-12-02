Feature: BusinessObjectTest
  As a Chief Financial Officer
  I want to test business objects used for salary calculations
  So that I can check the end of month billing processes

  Scenario: Check Development Team
    Given I have a business object
    And employee information has been received from the HR system
    When I set department name as Development
    And I set number of employees as 5
    Then the salary bill should be 300000 for department Development

  Scenario: Check Sales Department
    Given I have a business object
    And employee information has been received from the HR system
    When I set department name as Sales
    And I set number of employees as 5
    Then the salary bill should be 1000000 for department Sales