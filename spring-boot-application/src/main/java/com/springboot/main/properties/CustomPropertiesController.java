package com.springboot.main.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CustomPropertiesController {

    @Autowired
    private MyConfigurationProperty myProperty;

    @Autowired
    private MyAdditionalProperty myAdditionalProperty;

    @GetMapping("/properties")
    public void properties() throws IOException {
        System.out.println(this.myProperty.getName());
        System.out.println(this.myProperty.getLocation());

        System.out.println(this.myAdditionalProperty.getName());
        System.out.println(this.myAdditionalProperty.getValue());
    }
}
