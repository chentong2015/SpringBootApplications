package com.springboot.main.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@RestController
public class PropertiesController {

    @Autowired
    private MyConfigurationProperty myProperty;

    // TODO. 通过ResourceUtils直接获取classpath路径下文件
    @GetMapping("/properties")
    public void properties() throws IOException {
        System.out.println(this.myProperty.getName());
        System.out.println(this.myProperty.getLocation());

        File file = ResourceUtils.getFile("classpath:resource-property.xml");
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(file)) {
            props.loadFromXML(input);
        }
        System.out.println(props.getProperty("email.support"));
    }
}
