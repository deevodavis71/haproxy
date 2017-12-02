package com.example.demo.utils;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class BusinessDepartment {

    private String deptName;

    private int averageSalaryCost;

    private int numEmployees;

}
