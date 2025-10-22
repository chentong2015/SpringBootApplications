package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

// TODO. Spring Boot启动属性配置
// 1. 启动类型不能放置在空包路径下(default package)
// 2. 默认扫描范围@SpringBootApplication注解类型的package下所有包
//    扫描所有标注@Repository, @Service, @Component, @Controller...的类型
// 3. 可以移除对于特定名称的扫描，或者自定义扫描的包名scanBasePackages
//
// @ComponentScan(excludeFilters = {
//     @Filter(type = FilterType.CUSTOM,classes = {TypeExcludeFilter.class}),
//     @Filter(type = FilterType.CUSTOM,classes = {AutoConfigurationExcludeFilter.class}
//   )}
// @EntityScan("com.spring.data.jpa.entity")
// @EnableJpaRepositories("com.spring.data.jpa.repositories")
@SpringBootApplication
public class SpringBootStarterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarterApplication.class, args);
        System.out.println(applicationContext.isActive());

        ApplicationHome home = new ApplicationHome(SpringBootStarterApplication.class);
        File folder = home.getDir();          // returns the folder where the jar is.
        File folderSource = home.getSource(); // returns the jar absolute filepath.
    }
}
