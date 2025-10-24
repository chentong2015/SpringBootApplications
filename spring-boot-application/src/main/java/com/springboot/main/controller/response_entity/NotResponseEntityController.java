package com.springboot.main.controller.response_entity;

import com.springboot.main.model.ResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class NotResponseEntityController {

    // 正常将JSON对象封装到ResponseBody中返回
    @GetMapping(value = "/response-object")
    public ResponseObject getResponseObject() {
        return new ResponseObject("get: ok", 100);
    }
}
