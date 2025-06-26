package com.springboot.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Collections;
import java.util.List;

// TODO. Favicon ICON 默认加载路径
// - src/main/resources/favicon.ico
// - src/main/resources/static/favicon.ico
//
// 自定义Favicon ICON路径: 刷新页面缓存以获取更新
// 1. 设置spring.mvc.favicon.enabled=false
// 2. 注入SimpleUrlHandlerMapping自定义对象
@Configuration
public class FaviconConfiguration {

    @Bean
    public SimpleUrlHandlerMapping customFaviconHandlerMapping() {
        SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
        // Set this handler the highest priority.
        mapping.setOrder(Integer.MIN_VALUE);
        mapping.setUrlMap(Collections.singletonMap("/favicon.ico", faviconRequestHandler()));
        return mapping;
    }

    @Bean
    protected ResourceHttpRequestHandler faviconRequestHandler() {
        ResourceHttpRequestHandler requestHandler = new ResourceHttpRequestHandler();
        ClassPathResource classPathResource = new ClassPathResource("images/");
        List<Resource> locations = List.of(classPathResource);
        requestHandler.setLocations(locations);
        return requestHandler;
    }
}
