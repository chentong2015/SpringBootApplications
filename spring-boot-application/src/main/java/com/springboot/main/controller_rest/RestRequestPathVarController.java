package com.springboot.main.controller_rest;

import org.springframework.web.bind.annotation.*;

// TODO. 相同URL路径的不同请求会被分配到不同的Endpoints
@RestController
@RequestMapping("/v1/api/")
public class RestRequestPathVarController {

    // TODO. 推荐声明路径参数的name名称
    @DeleteMapping("/data/{id}")
    public String put(@PathVariable(name = "id") Long id) {
        return "delete: ok";
    }

    @PutMapping("/data/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        return "put: ok";
    }

    // 获取URL请求路径中"正则表达式"传递的字符串集
    // http://localhost:8080/v1/api/test-hello_123
    @GetMapping(value = "{publicId:[\\w\\-]+}")
    public String testRgxUrl(@PathVariable(value = "publicId") String publicId) {
        System.out.println(publicId);
        return "Get: " +  publicId;
    }
}
