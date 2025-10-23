package com.springboot.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1")
public class PrivateConsController {

    // TODO. 私有构造器不影响Bean注入, 可以访问Endpoint
    // Spring框架通过反射创建Bean, 通过setAccessible(true)来访问私有构造器
    private PrivateConsController() {
    }

    @GetMapping("/private-cons")
    public ResponseEntity<String> privateCons() {
        return ResponseEntity.ok().body("private cons value");
    }
}
