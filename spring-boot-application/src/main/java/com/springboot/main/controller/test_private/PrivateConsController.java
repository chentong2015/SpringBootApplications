package com.springboot.main.controller.test_private;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1/private")
public class PrivateConsController {

    // TODO. 私有构造器不影响Bean注入: constructor.setAccessible(true)
    // Spring框架通过反射访问私有构造器并创建Bean
    private PrivateConsController() {
    }

    @GetMapping("/private-cons")
    public ResponseEntity<String> privateCons() {
        return ResponseEntity.ok().body("private cons value");
    }
}
