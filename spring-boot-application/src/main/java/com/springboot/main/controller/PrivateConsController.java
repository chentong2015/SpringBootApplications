package com.springboot.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "/private")
public class PrivateConsController {

    // TODO. Spring无法注入private私有构造器的控制器 !!
    // There was an unexpected error (type=Not Found, status=404).
    // NoResourceFoundException: No static resource private/value.
    private PrivateConsController() {
    }

    @GetMapping("/value")
    public ResponseEntity<String> nullContent() {
        return ResponseEntity.ok().body("private value");
    }
}
