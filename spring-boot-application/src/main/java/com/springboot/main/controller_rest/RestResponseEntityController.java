package com.springboot.main.controller_rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class RestResponseEntityController {

    // 设置请求返回数据的MediaType类型
    @GetMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("result");
    }

    // 使用ResponseEntity作为请求的返回(带HttpStatus状态码)
    @GetMapping("/error")
    public ResponseEntity<String> error() {
        return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // 测试Server端正常处理，返回entity-body不包含任何内容
    @GetMapping("/no-content")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void testNoContent() {
    }

    // 测试HttpStatus NO_CONTENT
    @GetMapping("/testing")
    public Object testingNoContent() {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // TODO. 处理(消费)提供的JSON格式的数据
    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE,
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
