package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

// Will only be loaded when spring.profiles.active=dev
@Configuration
@Profile("dev")
public class MyProfileConfig {
}
