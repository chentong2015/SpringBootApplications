package com.springboot.main.controller.rest_controller;

import org.springframework.web.bind.annotation.*;

// TODO. @RestController本身不接受Path路径参数
@RestController
@RequestMapping("/v1/rest")
public class RestRequestController {

    @GetMapping(value = "/get")
    public String get() {
        return "get: ok";
    }
}
