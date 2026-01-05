package com.springboot.main.controller.controller_rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetSocketAddress;

@RestController
@RequestMapping("/v1/rest")
public class RestRequestHeaderController {

    // TODO. 通过HttpHeaders对象获取所有的请求参数
    @GetMapping("/all-headers")
    public ResponseEntity<String> getBaseUrl(@RequestHeader HttpHeaders headers) {
        InetSocketAddress host = headers.getHost();
        String url = "http://" + host.getHostName() + ":" + host.getPort();
        return new ResponseEntity<>(String.format("Base URL = %s", url), HttpStatus.OK);
    }

    // TODO: 必须在请求中提供特定的Header参数
    @GetMapping("/accept-header")
    public ResponseEntity<String> greeting(@RequestHeader("accept-language") String language) {
        // Code that uses the language variable
        return new ResponseEntity<>("greeting", HttpStatus.OK);
    }

    @GetMapping("/double-number")
    public ResponseEntity<String> doubleNumber(@RequestHeader("my-number") int myNumber) {
        String result = String.format("%d * 2 = %d", myNumber, (myNumber * 2));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
