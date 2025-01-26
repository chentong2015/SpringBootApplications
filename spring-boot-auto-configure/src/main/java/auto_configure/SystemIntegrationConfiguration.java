package auto_configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemIntegrationConfiguration {

    @Bean
    @ConditionalOnMissingBean
    AutoConfigService autoConfigService() {
        return new AutoConfigService();
    }

    public class AutoConfigService {
    }
}
