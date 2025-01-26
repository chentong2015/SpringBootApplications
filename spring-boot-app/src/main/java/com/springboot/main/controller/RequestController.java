package com.springboot.main.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/api/")
public class RequestController {

    // 处理(消费)提供的JSON格式的数据
    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void post() {
    }

    @PostMapping("/data/post")
    public String post(@RequestParam("id") Long id) {
        return "post: ok";
    }

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


    // 设置ResponseEntity header头部信息
    // "location": "/v1/statics/data/e17dd1f1" 标明重定向的URL路径
    @PostMapping("/response-with-header")
    public ResponseEntity<Void> responseWithHeader() {
        URI uri = UriComponentsBuilder
                .fromPath("/v1/statics/data/{id}")
                .buildAndExpand("e17dd1f1")
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    // 设置头部信息的同时，提供response body的数据
    @PostMapping("/response-with-header-and-body")
    public ResponseEntity<String> responseWithHeaderAndBody() {
        URI uri = UriComponentsBuilder
                .fromPath("/v1/statics/data/{id}")
                .buildAndExpand("e17dd1f1")
                .toUri();
        return ResponseEntity.created(uri).body("body message");
    }
}
