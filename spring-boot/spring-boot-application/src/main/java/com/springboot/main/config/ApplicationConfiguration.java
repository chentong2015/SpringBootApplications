package com.springboot.main.config;

import com.springboot.main.properties.MyConfigurationProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
}
