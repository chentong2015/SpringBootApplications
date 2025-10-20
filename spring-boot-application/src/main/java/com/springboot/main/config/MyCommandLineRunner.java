package com.springboot.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// 在tomcat启动完成，应用运行起来之后
// 1. 自动调用CommandLineRunner的run()实现方法
// 2. 通过run()方法来初始化或者测试应用的启动状态
@Component
public class MyCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Application runs ok");
        System.out.println("Application args:" + args.length);
    }
}
