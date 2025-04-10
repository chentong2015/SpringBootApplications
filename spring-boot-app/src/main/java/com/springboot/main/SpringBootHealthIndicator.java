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
        // Path used to compute available disk space
        File path = new File(".");
        long diskUsableInBytes = path.getUsableSpace();

        // Check if space is more than 100M
        boolean hasEnoughSpace = diskUsableInBytes >= 100 * 1024 * 1024;

        // UP means there is enough usable memory.
        Status status = hasEnoughSpace ? Status.UP : Status.DOWN;

        // In addition to reporting the status,
        // we can attach additional key-value details using the withDetail(key, value)
        return Health.status(status)
                .withDetail("usable memory", diskUsableInBytes)
                .withDetail("threshold", 100 * 1024 * 1024)
                .build();
    }
}
