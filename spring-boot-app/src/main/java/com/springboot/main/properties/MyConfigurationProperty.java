package com.springboot.main.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

// TODO. 匹配引入特定前缀的属性并注入创建的Bean对象实例
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
