package com.example.demo.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import lombok.Getter;

@Service
@Getter
public class AuditLogSystem {

    private Map<Date, String> audits = new HashMap<>();

    public void addAudit(String audit) {

        audits.put(new Date(), audit);

    }

}
