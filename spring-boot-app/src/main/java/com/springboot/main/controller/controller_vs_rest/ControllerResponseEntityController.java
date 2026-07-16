package com.springboot.main.controller.controller_vs_rest;

import com.springboot.main.model.ResponseObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO. 返回ResponseEntity自定义封装返回ResponseBody结果
@Controller
@RequestMapping("/v1/controller-response-entity")
public class ControllerResponseEntityController {

    @GetMapping(value = "/get-string")
    public ResponseEntity<String> getString() {
        return new ResponseEntity<>("get: ok", HttpStatus.OK);
    }

    @GetMapping(value = "/get-object")
    public ResponseEntity<ResponseObject> getObject() {
        ResponseObject object = new ResponseObject("get: ok", 100);
        return ResponseEntity.ok().body(object);
    }
}
