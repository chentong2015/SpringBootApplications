package com.springboot.main.controller.controller_rest;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/rest")
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

    // 支持传递参数列表
    // http://localhost:8080/v1/rest/data/param?id=1,2,3
    // http://localhost:8080/v1/rest/data/param?id=1&id=2
    @GetMapping("/data/param")
    public String getParamList(@RequestParam(name = "id") List<String> id) {
        return "IDs are " + id;
    }
}
