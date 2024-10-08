package com.springboot.main.resources;

import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ResourcesPropertyLoader {

    public ResourcesPropertyLoader() throws IOException {
        loadPropertiesFile();
        loadXmlPropertyFile();

        // TODO. 从指定的资源文件路径中批量加载配置属性到Environment
        // ConfigurableEnvironment environment;
        // List<PropertySource<?>> propertySources = propertiesPropertySourceLoader.load("Config", resource);
        // propertySources.forEach(environment.getPropertySources()::addLast);
    }

    private void loadPropertiesFile() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("resource-property.properties");

        PropertiesPropertySourceLoader propertySourceLoader = new PropertiesPropertySourceLoader();
        List<PropertySource<?>> properties = propertySourceLoader.load("SourceName", resource);
        System.out.println(properties.size());

        System.out.println(properties.get(0).getProperty("source.id"));
        System.out.println(properties.get(0).getProperty("source.value"));
    }

    // TODO. XML格式的属性配置文件必须包含DOCTYPE文件格式定义(约束)
    // An XML properties document must contain the DOCTYPE declaration
    private void loadXmlPropertyFile() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("resource-property.xml");

        PropertiesPropertySourceLoader propertySourceLoader = new PropertiesPropertySourceLoader();
        List<PropertySource<?>> properties = propertySourceLoader.load("XmlSourceName", resource);

        System.out.println(properties.get(0).getProperty("http.port"));
        System.out.println(properties.get(0).getProperty("http.server"));
    }
}
