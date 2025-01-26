package com.springboot.main;

import com.springboot.main.properties.MyConfigurationProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import java.util.List;
import java.util.concurrent.Executor;

// 不推荐使用注解@EnableWebMvc，可导致无法使用WebMvcAutoConfiguration功能
@Configuration
@EnableAsync
@EnableConfigurationProperties({MyConfigurationProperty.class})
public class ApplicationConfiguration {

    // 使用线程池来运行并发的线程，设置最大并发线程数和阻塞队列
    @Bean(name = "asyncTaskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("Server thread:");
        executor.initialize();
        return executor;
    }

    // TODO. ShallowEtagHeaderFilter
    // 在返回的Response Headers中添加"Etag"属性
    // 在返回的Response Headers中添加"Content-Length"(通过缓存整个response结果来实现)
    @Bean
    public FilterRegistrationBean<ShallowEtagHeaderFilter> filterRegistrationBean() {
        FilterRegistrationBean<ShallowEtagHeaderFilter> filterBean = new FilterRegistrationBean<>();
        filterBean.setFilter(new ShallowEtagHeaderFilter());
        filterBean.setUrlPatterns(List.of("*"));
        return filterBean;
    }
}
