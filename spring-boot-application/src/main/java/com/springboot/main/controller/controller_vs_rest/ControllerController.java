package com.springboot.main.controller.controller_vs_rest;

import com.springboot.main.model.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO. @Controller注解 => 可能Not Found 404错误
//  - 不会自动封装结果到ResponseBody, 无法直接返回结果对象
//  - 必须手动添加ResponseBody注解标记返回Body结果
@Controller
@RequestMapping(value = "/v1/controller")
public class ControllerController {

    @GetMapping(value = "/get-string")
    @ResponseBody
    public String getString() {
        return "get: ok";
    }

    @GetMapping(value = "/get-object")
    public ResponseObject getObject() {
        return new ResponseObject("get: ok", 100);
    }
}
