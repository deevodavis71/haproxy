package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: stevedavis
 * Date: 25/11/2017
 * Time: 11:11
 * Description:
 */
@RestController
@RequestMapping("/api")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        System.out.println (new java.util.Date() + " ... got a call");
        return "Hello World!";
    }

}
