package com.springboot.main.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

    @Autowired
    private MyConfigurationProperty myProperty;

    @GetMapping("/properties")
    public void properties() {
        System.out.println(this.myProperty.getName());
        System.out.println(this.myProperty.getLocation());
    }
}
