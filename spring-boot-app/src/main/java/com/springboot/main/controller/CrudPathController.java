package com.springboot.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO. Endpoints API通过正则表达式来获取URL传递参数
@RestController
@RequestMapping(value = "/v1/path/")
public class CrudPathController {

      // 具名: 获取URL请求路径中传递的字符串集
      // http://localhost:8080/v1/path/test-hello_123
      @GetMapping(value = "{publicId:[\\w\\-]+}")
      public String testRgxUrl(@PathVariable(value = "publicId") String publicId) {
            System.out.println(publicId);
            return "Get: " +  publicId;
      }
}
