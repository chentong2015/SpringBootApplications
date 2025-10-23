package org.springboot.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Duration;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    // 所有访问/resources/**路径的请求都能从Locations中找到静态文件
    // http://localhost:8080/v1/resources/Hello.html
    //
    // 支持设置多个静态资源路径位置
    // .addResourceLocations("/resources/","classpath:/other-resources/");
    //
    // 配置静态资源的缓存策略, 避免后端频繁的返回数据(无更新时)
    // The resources are served with 7 days future expiration
    // to ensure maximum use of the browser cache and a reduction in HTTP requests made by the browser.
    // The Last-Modified information is deduced from Resource#lastModified
    // so that HTTP conditional requests are supported with "Last-Modified" headers.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public", "classpath:/static/")
                .setCacheControl(CacheControl.maxAge(Duration.ofDays(7)));
    }
}
