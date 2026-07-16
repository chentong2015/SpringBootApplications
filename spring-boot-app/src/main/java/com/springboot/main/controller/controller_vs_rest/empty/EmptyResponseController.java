package com.springboot.main.controller.controller_vs_rest.empty;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empty/controller")
public class EmptyResponseController {

    // TODO. 返回ResponseEntity空对象实体
    @GetMapping("/void")
    public ResponseEntity<Void> testVoid() {
        return ResponseEntity.noContent().build();
    }

    // TODO. 返回BodyBuilder(非对象)会被@Controller解析成字符串视图名"no-content"
    // Internal Server Error, status=500
    // Circular view path [no-content]: would dispatch back to the current handler URL [/no-content] again.
    @GetMapping("/no-content")
    public Object testNoContent() {
        return ResponseEntity.noContent();
    }
}
