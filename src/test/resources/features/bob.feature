Feature: Salary Checker
  As a Chief Financial Officer
  I want to test business objects used for salary calculations
  So that I can check the end of month billing processes

  Scenario: Check Average Salary Information
    Given employee information has been received from the HR system
    Then the average salary for employees of department Development will be 60000
    And the average salary for employees of department Sales will be 200000

  Scenario: Check Development Team Salaries
    Given I have a business object
    And employee information has been received from the HR system
    When I set department name as Development
    And I set number of employees as 5
    Then the salary bill should be 300000 for department Development

  Scenario: Check Sales Department Salaries
    Given I have a business object
    And employee information has been received from the HR system
    When I set department name as Sales
    And I set number of employees as 5
    Then the salary bill should be 1000000 for department Sales