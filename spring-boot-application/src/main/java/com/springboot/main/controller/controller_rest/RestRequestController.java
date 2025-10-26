package com.springboot.main.controller.controller_rest;

import org.springframework.web.bind.annotation.*;

// TODO. @RestController本身不接受Path路径参数
@RestController
@RequestMapping("/v1/rest")
public class RestRequestController {

    @GetMapping(value = "/base")
    public String base() {
        return "get: ok";
    }
}
