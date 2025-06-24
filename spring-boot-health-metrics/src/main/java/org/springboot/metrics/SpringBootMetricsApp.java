package org.springboot.metrics;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMetricsApp {

    @Autowired
    DiskSpaceMetrics diskSpaceMetrics;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMetricsApp.class, args);
    }

    @PostConstruct
    public void postConstruct() {
        Health health = diskSpaceMetrics.health();
        System.out.println(health.getStatus());
        System.out.println(health.getStatus().getCode());
    }
}
