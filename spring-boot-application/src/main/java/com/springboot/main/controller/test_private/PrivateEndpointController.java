package com.springboot.main.controller.test_private;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/v1/private")
public class PrivateEndpointController {

    private PrivateEndpointController() {
    }

    // TODO. 私有方法不影响Endpoint访问: method.setAccessible(true)
    // 私有方法可能影响Doc文档生成或相关AOP代理拦截 ?
    @GetMapping("/private-method")
    private ResponseEntity<String> privateMethod() {
        return ResponseEntity.ok().body("private value");
    }
}
