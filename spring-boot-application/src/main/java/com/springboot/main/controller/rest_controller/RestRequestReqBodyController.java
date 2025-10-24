package com.springboot.main.controller.rest_controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/rest")
public class RestRequestReqBodyController {

    // TODO. 在请求时通过RequestBody时传递大JSON对象
    @PostMapping(value = "/post",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseBean post(@RequestBody RequestBean requestBean) {
        System.out.println(requestBean.message);
        return new ResponseBean("content");
    }

    public class RequestBean {
        private String message;
        public RequestBean(String message) {
            this.message = message;
        }
    }

    public class ResponseBean {
        private String message;
        public ResponseBean(String message) {
            this.message = message;
        }
    }
}
