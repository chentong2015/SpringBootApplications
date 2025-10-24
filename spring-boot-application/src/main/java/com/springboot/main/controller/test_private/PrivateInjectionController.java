package com.springboot.main.controller.test_private;

import com.springboot.main.service.PrivateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/private")
public class PrivateInjectionController {

    private PrivateService privateService;

    private PrivateInjectionController(PrivateService privateService) {
        this.privateService = privateService;
    }

    // 私有的方法也能获取注入的Bean对象
    @GetMapping("/private-injection")
    private ResponseEntity<String> privateInjection() {
        this.privateService.print();
        return ResponseEntity.ok().body("private injection value");
    }
}
