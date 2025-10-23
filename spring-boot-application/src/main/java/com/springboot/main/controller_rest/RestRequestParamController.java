package com.springboot.main.controller_rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/")
public class RestRequestParamController {

    // TODO. @RequestParam 注解参数设置
    // 1. @RequestParam("message") String message 默认值为null
    // 2. @RequestParam(name="message", required=false) 设置非必须参数
    // 3. @RequestParam(name="message", defaultValue="default value") 设置参数默认值
    // 4. @RequestParam(name = "message") Optional<String> message

    @GetMapping("/test")
    public String test(@RequestParam(name = "name", defaultValue = "victor") String name) {
        return "hello " + name;
    }

    @PostMapping("/data/post")
    public String post(@RequestParam(name = "id", required = false) Long id) { return "post: ok"; }
}
