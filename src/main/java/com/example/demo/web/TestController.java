package com.example.demo.web;

import java.net.URL;
import java.net.URLClassLoader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.profiles.DefaultValues;

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
    public String test() throws Exception {

        //Get the System Classloader
        ClassLoader sysClassLoader = ClassLoader.getSystemClassLoader();

        //Get the URLs
        ClassLoader effectiveClassLoader = getClass().getClassLoader();
        URL[] classPath = ((URLClassLoader) effectiveClassLoader).getURLs();
        for (URL u : classPath) {
            System.out.println(u);
        }

        System.out.println(new java.util.Date() + " ... got a call");

        Class<?> dv = Class.forName("com.example.demo.profiles.DefaultValues");
        String name = (String) dv.getDeclaredField("NAME").get(null);

        System.out.println("Static loaded: " + DefaultValues.NAME);
        System.out.println("Static loaded: " + DefaultValues.doIt());

        return "Hello World from " + name + "!";

    }

}
