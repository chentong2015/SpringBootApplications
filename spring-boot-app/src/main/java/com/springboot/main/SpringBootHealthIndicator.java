package com.springboot.main;

import org.springframework.stereotype.Component;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import java.io.File;

@Component
public class SpringBootHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        // 获取C盘剩余的Drive Space存储空间大小
        // Path used to compute available disk space
        File path = new File(".");
        long diskUsableInBytes = path.getUsableSpace() / (1024 * 1024);

        // Check if space is more than 100M
        boolean hasEnoughSpace = diskUsableInBytes >= 100;

        // UP means there is enough usable memory.
        Status status = hasEnoughSpace ? Status.UP : Status.DOWN;

        // In addition to reporting the status,
        // we can attach additional key-value details using the withDetail(key, value)
        return Health.status(status)
                .withDetail("Usable memory (M)", diskUsableInBytes)
                .withDetail("Threshold (M)", 100)
                .build();
    }
}
