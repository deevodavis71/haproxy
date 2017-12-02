Feature: Check HR System Salary Information

  As a HR Manager
  I want to check that all departments have salary information
  So that employees all get paid

  Scenario: Request Missing Salary Information

    Given employee information has been received from the HR system
    When I request the average salary for employees of a missing department
    Then the error "Missing Salary Details" will be logged

  Scenario Outline: Check Average Salary Information using provided values

    Given employee information has been received from the HR system
    Then the average salary for employees of department <dept> will be <avg_salary>

    Examples: Dept Salaries
      | dept        | avg_salary |
      | Development | 60000      |
      | Sales       | 200000     |

  Scenario: Check Logged Audit Information

    * check "Missing Salary Details" error has been logged
