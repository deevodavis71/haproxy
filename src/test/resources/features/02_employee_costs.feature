Feature: Employee Salary Costs

  As a Chief Financial Officer
  I want to test logic used for salary calculations
  So that I can validate the end of month billing processes

  Background: Runs before each scenario shown below

    Given I want to check a department
    And employee information has been received from the HR system

  Scenario: Check Development Team Salaries

    When I set department name as Development
    And I set number of employees as 5
    Then the total salary bill should be 300000 for the department Development

  Scenario: Check Sales Department Salaries

    When I set department name as Sales
    And I set number of employees as 5
    Then the total salary bill should be 1000000 for the department Sales

  Scenario Outline: This is exactly the same as the two scenarios above, except it use a data table

    When I set department name as <dept>
    And I set number of employees as <num_employees>
    Then the total salary bill should be <total> for the department <dept>

    Examples: Departments, Employees and Totals
      | dept        | num_employees | total   |
      | Development | 5             | 300000  |
      | Sales       | 5             | 1000000 |

