package com.springboot.main.controller.controller_vs_rest.empty;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empty/rest/controller")
public class EmptyResponseRestController {

    // TODO. 返回ResponseEntity空对象实体
    @GetMapping("/void")
    public Object testVoid() {
        return ResponseEntity.noContent().build();
    }

    // TODO. 返回BodyBuilder(非对象)无法被@RestController解析并序列化成JSON类型
    // type=Not Acceptable, status=406
    @GetMapping("/no-content")
    public Object testNoContent() {
        return ResponseEntity.noContent();
    }
}
