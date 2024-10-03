package spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootTestingApplication {

    // TODO: 通过获取ApplicationContext容器测试main()方法启动
    public static void main(String[] args) {
        System.out.println("Start application");
        SpringApplication.run(SpringBootTestingApplication.class, args);
    }
}