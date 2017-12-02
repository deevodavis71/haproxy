package com.example.demo.utils;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class BusinessObject {

    private int numEmployees;

    private int salaryCost;

    private String deptName;

}
