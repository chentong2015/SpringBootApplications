package com.springboot.main.controller.controller_vs_rest;

import com.springboot.main.model.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO. @Controller注解不会自动解析封装结果到ResponseBody
@Controller
@RequestMapping(value = "/v1/controller")
public class ControllerController {

    // @ResponseBody 必须手动标记 !!
    @GetMapping(value = "/get-string")
    public String getString() {
        return "get: ok";
    }

    @GetMapping(value = "/get-object")
    public ResponseObject getObject() {
        return new ResponseObject("get: ok", 100);
    }
}
