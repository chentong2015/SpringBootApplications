package com.springboot.main.controller.return_response_entity;

import com.springboot.main.model.ResponseObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ReturnResponseEntityController {

    // TODO. 通过ResponseEntity返回完整的HTTP响应封装对象
    @GetMapping(value = "/responseEntity-object", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseObject> getResponseEntityObject() {
        ResponseObject object = new ResponseObject("get: ok", 100);
        return ResponseEntity.ok().body(object);
    }
}
