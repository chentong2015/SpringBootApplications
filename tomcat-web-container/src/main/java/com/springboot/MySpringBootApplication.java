package com.springboot;

import com.springboot.tomcat.SpringTomcatStarter;

@IMySpringBootApplication
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringTomcatStarter.run(MySpringBootApplication.class);
        System.out.println("App started");
    }
}
