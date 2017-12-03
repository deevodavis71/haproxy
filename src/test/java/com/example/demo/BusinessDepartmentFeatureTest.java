package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.support.AppConfiguration;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "classpath:features")
@ContextConfiguration(classes = AppConfiguration.class)
public class BusinessDepartmentFeatureTest {

}
