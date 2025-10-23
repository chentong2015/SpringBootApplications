package com.springboot.main.controller_redirect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(value = "/v1")
public class RedirectController {

    // TODO. 直接重定向到另一个Endpoint端口
    @GetMapping(value = "/other")
    public String other() {
        return "redirect:/v1/base";
    }

    @GetMapping(value = "/base")
    @ResponseBody
    public String base() {
        return "Base page";
    }


    // TODO. 指定重定向URL路径并提供路径参数
    @GetMapping(value = "/redirect")
    public ResponseEntity<String> redirect() {
        URI uri = UriComponentsBuilder
                .fromPath("/v1/data/{id}")
                .buildAndExpand("e17dd1f1")
                .toUri();
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(uri).build();
    }

    @GetMapping(value = "/data/{id}")
    @ResponseBody
    public String data(@PathVariable(name = "id") String id) {
        return "Redirect data page: " + id;
    }
}
