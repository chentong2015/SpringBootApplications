package auto_configure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemIntegrationConfiguration {

    // 在没有注入特定Bean的情况下创建实例对象
    @Bean
    @ConditionalOnMissingBean
    AutoConfigService autoConfigService() {
        return new AutoConfigService();
    }

    public class AutoConfigService {
    }
}
