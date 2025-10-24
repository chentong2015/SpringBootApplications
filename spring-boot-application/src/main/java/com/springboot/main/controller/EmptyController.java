package com.springboot.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

// TODO. 返回entity-body不包含任何内容
@Controller
public class EmptyController {

    @GetMapping("/void")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testVoid() {
    }

    @GetMapping("/no-content")
    public Object testNoContent() {
        return ResponseEntity.noContent();
    }

}
