package com.springboot.main.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

// TODO. 对于Response Url重定向的构建
@Controller(value = "/v1")
public class ResponseRedirectController {

    // 对于不带body的ResponseEntity的build构建
    @GetMapping("/null-content")
    public ResponseEntity<Void> nullContent() {
        URI location = URI.create("uri");
        return ResponseEntity.created(location).build();
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
