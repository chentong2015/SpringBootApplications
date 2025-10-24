package com.springboot.main.controller.controller_vs_rest;

import com.springboot.main.model.ResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO. @RestController默认将结果封装到ResponseBody返回
@RestController
@RequestMapping(value = "/v1/rest-controller")
public class RestControllerController {

    @GetMapping(value = "/get-String")
    public String getString() {
        return "get: ok";
    }

    @GetMapping(value = "/get-object")
    public ResponseObject getObject() {
        return new ResponseObject("get: ok", 100);
    }
}
