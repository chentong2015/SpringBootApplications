package com.springboot.main.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriTemplate;

import java.util.Map;

@RestController
@RequestMapping("/v1")
public class HttpRequestController {

    // TODO. 可以在Endpoint拿到Request和Response执行判断或拦截
    @GetMapping("/http")
    public String http(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURL().toString();
        System.out.println(url);

        // http://localhost:8080/v1/http 从请求的路径中解析特定名称
        UriTemplate uriTemplate = new UriTemplate("/v1/{path}");
        Map<String, String> uriVariables = uriTemplate.match(url);
        System.out.println(uriVariables.get("path")); // http

        Cookie cookie = new Cookie("cookieName", "cookieValue");
        response.addCookie(cookie);
        return "Http OK";
    }
}
