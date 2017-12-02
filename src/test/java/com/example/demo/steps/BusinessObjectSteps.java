package com.example.demo.steps;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.utils.AuditLogSystem;
import com.example.demo.utils.BusinessDepartment;
import com.example.demo.utils.HumanResourceSystem;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessObjectSteps {

    @Mock
    private HumanResourceSystem hrSystem;

    @Mock
    private AuditLogSystem auditSystem;

    static private List<String> audits = new ArrayList<>(); // Only required to mock up audit system log events

    private BusinessDepartment department;

    @Before // Note that this is the Cucumber annotation, not the JUnit one
    public void Before() {

        // We need to call this to initialise mocks, as we aren't able to run under the
        // Mockito JUnit runner as we have to use the Cucumber runner instead
        MockitoAnnotations.initMocks(this);

        // Mock that the integration to the HR system has worked
        // and that we have data available
        Mockito.when(hrSystem.isDataReceived()).thenReturn(true);

        // Mock up the set of salaries that will come back from the
        // HR system
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Development", 60_000);
        salaries.put("Sales", 200_000);
        Mockito.when(hrSystem.getAverageSalaries()).thenReturn(salaries);

        // Mock up the auditing system, instead storing the audits in
        // a locally cached list - note the difference in my mocked type (a List<String>)
        // versus the type in the actual object (Map<Date, String>)
        Mockito.doAnswer(invocationOnMock -> {
            audits.add(invocationOnMock.getArgument(0));
            return null;
        }).when(auditSystem).addAudit(anyString());

    }

    @When("^I request the average salary for employees of an unknown department$")
    public void missingDepartment() {

        assertNull(hrSystem.getAverageSalaries().get("Missing Dept"));

    }

    @Then("^the error (.*) will be logged$")
    public void logAnError(String error) {

        auditSystem.addAudit(error);

    }

    @Given("^I want to check a department$")
    public void initialiseDepartment() {

        department = new BusinessDepartment();

    }

    @Given("^employee information has been received from the HR system$")
    public void checkBillingSystem() {

        assertEquals(true, hrSystem.isDataReceived());

    }

    @When("^I set department name as (.*)$")
    public void setDeptName(String name) {

        department.setDeptName(name);

    }

    @When("^I set number of employees as (\\d*)$")
    public void setDeptName(int profit) {

        department.setNumEmployees(profit);

    }

    @Then("^the average salary for employees of department (.*) will be (\\d*)$")
    public void testAverageSalary(String dept, int averageSalary) {

        assertNotNull(hrSystem.getAverageSalaries().get(dept));
        assertEquals(averageSalary, hrSystem.getAverageSalaries().get(dept).intValue());

    }

    @Then("^the total salary bill should be (\\d*) for the department (.*)$")
    public void testSalaryBill(int salaryBill, String dept) {

        assertEquals(salaryBill, department.getNumEmployees() * hrSystem.getAverageSalaries().get(dept));
        assertEquals(dept, department.getDeptName());

    }

    @Given("^check (.*) error has been logged$")
    public void checkErrorHasBeenLogged(String audit) {

        assertEquals(1, audits.size());
        assertTrue(audits.contains(audit));

    }
}
