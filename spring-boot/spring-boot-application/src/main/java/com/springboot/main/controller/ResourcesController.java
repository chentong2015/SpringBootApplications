package com.springboot.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

@RestController
public class ResourcesController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/resources")
    public ResponseEntity<String> resource() throws IOException {
        System.out.println("Load classpath resources");
        String content = this.resourceLoader.getResource("classpath:resource.xml")
                .getContentAsString(Charset.defaultCharset());
        return ResponseEntity.ok(content);
    }
}
