package com.springboot.main.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/api/")
public class CrudController {

    @GetMapping(value = "/get")
    public String get() {
        return "get: ok";
    }

    // 测试设置参数的默认值
    @GetMapping("/test")
    public String test(@RequestParam(name = "name", defaultValue = "victor") String name) {
        return "hello " + name;
    }

    // 设置非必须参数required=false
    @PostMapping("/data/post")
    public String post(@RequestParam(name = "id", required = false) Long id) { return "post: ok"; }

    // 不同类型的请求会被分发到不同的Controller方法
    // 即使具有完全一致的URL路径，DELETE Request不会分配到PUT Method
    @DeleteMapping("/data/{id}")
    public String put(@PathVariable Long id) {
        return "delete: ok";
    }

    @PutMapping("/data/{id}")
    public String delete(@PathVariable Long id) {
        return "put: ok";
    }


    // TODO. 处理(消费)提供的JSON格式的数据
    @PostMapping(value = "/data",
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
