package com.example.demo.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class World {

    // Shared data between tests...

    private List<String> audits = new ArrayList<>(); // Only required to mock up audit system log events

}
