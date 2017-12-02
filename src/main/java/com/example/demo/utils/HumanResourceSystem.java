package com.example.demo.utils;

import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class HumanResourceSystem {

    private boolean dataReceived;

    private Map<String, Integer> salaries;

}
