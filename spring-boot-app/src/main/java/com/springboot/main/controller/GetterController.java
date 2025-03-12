package com.springboot.main.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/v1")
public class GetterController {

    @GetMapping(value = "/base")
    @ResponseBody
    public String base() {
        return "Base response";
    }

    // 设置请求返回数据的MediaType类型
    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("result");
    }

    // 测试设置参数的默认值，required=true默认为必选
    @GetMapping("/test")
    public ResponseEntity<String> test(@RequestParam(name = "name", defaultValue = "victor") String name) {
        return ResponseEntity.ok("hello " + name);
    }

    // 测试HttpStatus NO_CONTENT
    @GetMapping("/testing")
    public Object testingNoContent() {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // 测试返回的结果中包含content
    @GetMapping("/error")
    public ResponseEntity<String> error() {
        return new ResponseEntity<>("INTERNAL SERVER ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // 测试Server端正常处理，返回entity-body不包含任何内容
    @GetMapping("/no-content")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testNoContent() {
    }

    // TODO. 对于不带body的ResponseEntity的build构建
    @GetMapping("/null-content")
    public ResponseEntity<Void> nullContent() {
        URI location = URI.create("uri");
        return ResponseEntity.created(location).build();
    }
}
