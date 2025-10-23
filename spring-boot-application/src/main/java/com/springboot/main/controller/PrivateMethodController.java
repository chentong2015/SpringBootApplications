package com.springboot.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1")
public class PrivateMethodController {

    private PrivateMethodController() {
    }

    // TODO. Spring无法注入private私有构造器的控制器 !!
    // There was an unexpected error (type=Not Found, status=404).
    // NoResourceFoundException: No static resource private/value.
    @GetMapping("/private-method")
    private ResponseEntity<String> privateMethod() {
        return ResponseEntity.ok().body("private value");
    }
}
