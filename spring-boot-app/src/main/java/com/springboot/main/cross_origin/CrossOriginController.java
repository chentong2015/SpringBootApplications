package com.springboot.main.cross_origin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO. Access Control Allow Origin
// https://spring.io/guides/gs/rest-service-cors/
// 服务端API必须指定支持的跨域请求，确保接受来自JS Ajax的请求
@RestController
public class CrossOriginController {

    @GetMapping("/status/test")
    @CrossOrigin(origins = "http://localhost:8080")
    public String test() {
        // return "<div>test</div>";
        return "{\"order_id\": \"test order id\"}";
    }

    // 允许指定的URL发送跨域请求, 接受来自Javascript Ajax的请求
    @GetMapping("/greeting")
    @CrossOrigin(origins = "http://localhost:63342")
    public Greeting greeting(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(10, "hello " + name);
    }

    class Greeting {
        private final long id;
        private final String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }
    }
}
