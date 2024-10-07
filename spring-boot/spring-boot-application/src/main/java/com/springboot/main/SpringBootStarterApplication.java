package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// TODO. Spring Boot启动注意
// 1. 启动类型不能放置在空包路径下(default package)
// 2. 默认扫描范围@SpringBootApplication注解类型的package下所有包
//    扫描所有标注@Repository, @Service, @Component, @Controller...的类型
// 3. 可以移除对于特定名称的扫描，或者自定义扫描的包名scanBasePackages
//    @ComponentScan(excludeFilters = {
//      @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
//      @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class}
//    )}
@SpringBootApplication
// @EntityScan("com.spring.data.jpa.entity")
// @EnableJpaRepositories("com.spring.data.jpa.repositories")
public class SpringBootStarterApplication {

    public static void main(String[] args) {
        // Stop showing slf4j internal source code message
        System.setProperty("slf4j.internal.verbosity", "WARN");

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarterApplication.class, args);
        System.out.println(applicationContext.isActive());
    }
}
