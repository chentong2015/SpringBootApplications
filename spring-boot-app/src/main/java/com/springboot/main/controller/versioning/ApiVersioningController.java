package com.springboot.main.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

// TODO. 定义Path路径中的version版本, 划分不同的Endpoints
// # Spring boot 4 new feature, support different ApiVersionStrategy
@RestController
@RequestMapping("/{version}") // 将version添加到path请求路径中
public class ApiVersioningController {

    // http://localhost:8080/v1/check
    @GetMapping(value = "/check", version = "1")
    public String checkVersion() {
        ObjectMapper objectMapper = new ObjectMapper();
        return "Check version 1";
    }

    // http://localhost:8080/v2/check2
    @GetMapping(value = "/check2", version = "2")
    public String checkVersion2() {
        ObjectMapper objectMapper = new ObjectMapper();
        return "Check version 2";
    }
}