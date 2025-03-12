package com.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;


@SpringBootApplication
public class SpringBootStarterApplication {

    public static void main(String[] args) {
        // Stop showing slf4j internal source code message
        System.setProperty("slf4j.internal.verbosity", "WARN");

        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootStarterApplication.class, args);
        System.out.println(applicationContext.isActive());

        ApplicationHome home = new ApplicationHome(SpringBootStarterApplication.class);
        File folder = home.getDir();          // returns the folder where the jar is.
        File folderSource = home.getSource(); // returns the jar absolute filepath.
    }
}
