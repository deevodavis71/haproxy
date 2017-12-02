package com.example.demo.steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.demo.utils.BusinessObject;
import com.example.demo.utils.HumanResourceSystem;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BusinessObjectSteps {

    private BusinessObject bob;

    @Mock
    private HumanResourceSystem hrSystem;

    @Before
    public void Before() {

        MockitoAnnotations.initMocks(this);

        Mockito.when(hrSystem.isDataReceived()).thenReturn(true);

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Development", 60_000);
        salaries.put("Sales", 200_000);
        Mockito.when(hrSystem.getSalaries()).thenReturn(salaries);

    }

    @Given("^I have a business object$")
    public void initialiseBob() {

        bob = new BusinessObject();

    }

    @Given("^employee information has been received from the HR system$")
    public void checkBillingSystem() {

        assertEquals(true, hrSystem.isDataReceived());

    }

    @When("^I set department name as (.*)$")
    public void setDeptName(String name) {

        bob.setDeptName(name);

    }

    @When("^I set number of employees as (\\d*)$")
    public void setDeptName(int profit) {

        bob.setNumEmployees(profit);

    }

    @Then("^the average salary for employees of department (.*) will be (\\d*)$")
    public void testAverageSalary(String dept, int averageSalary) {

        assertNotNull(hrSystem.getSalaries().get(dept));
        assertEquals(averageSalary, hrSystem.getSalaries().get(dept).intValue());

    }

    @Then("^the salary bill should be (\\d*) for department (.*)$")
    public void testSalaryBill(int salaryBill, String dept) {

        assertEquals(salaryBill, bob.getNumEmployees() * hrSystem.getSalaries().get(dept));
        assertEquals(dept, bob.getDeptName());

    }
}
