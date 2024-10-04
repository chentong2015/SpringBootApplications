package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestingApplication {

    public static void main(String[] args) {
        System.out.println("Start application");
        SpringApplication.run(SpringBootTestingApplication.class, args);
    }
}