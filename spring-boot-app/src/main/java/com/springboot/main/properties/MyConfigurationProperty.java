package com.springboot.main.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO. 使用注解将属性批量设置到Java Object. 作为Bean对象使用
@ConfigurationProperties(prefix = "my")
public class MyConfigurationProperty {

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
