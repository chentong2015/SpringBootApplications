package com.springboot.main.controller_rest;

import org.springframework.web.bind.annotation.*;

// TODO. @RestController本身不接受Path路径参数
@RestController
@RequestMapping("/v1/api/")
public class RestRequestController {

    @GetMapping(value = "/get")
    public String get() {
        return "get: ok";
    }

    // 测试设置参数的默认值
    @GetMapping("/test")
    public String test(@RequestParam(name = "name", defaultValue = "victor") String name) {
        return "hello " + name;
    }

    // 设置非必须参数required=false
    @PostMapping("/data/post")
    public String post(@RequestParam(name = "id", required = false) Long id) { return "post: ok"; }

    // 不同类型的请求会被分发到不同的Controller方法
    // 即使具有完全一致的URL路径，DELETE Request不会分配到PUT Method
    @DeleteMapping("/data/{id}")
    public String put(@PathVariable Long id) {
        return "delete: ok";
    }

    @PutMapping("/data/{id}")
    public String delete(@PathVariable Long id) {
        return "put: ok";
    }

    // 获取URL请求路径中"正则表达式"传递的字符串集
    // http://localhost:8080/v1/path/test-hello_123
    @GetMapping(value = "{publicId:[\\w\\-]+}")
    public String testRgxUrl(@PathVariable(value = "publicId") String publicId) {
        System.out.println(publicId);
        return "Get: " +  publicId;
    }
}
