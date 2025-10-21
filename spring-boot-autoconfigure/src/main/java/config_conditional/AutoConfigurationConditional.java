package config_conditional;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// TODO. autoconfigure 自动装配中的条件注解
// @ConditionalOnProperty 满足指定环境property属性设置才会注入配置中的beans
// matchIfMissing=true    即使属性条件不满足仍然match并注入
@Configuration
@ConditionalOnProperty(value = "isEnabled", havingValue = "true", matchIfMissing = false)
public class AutoConfigurationConditional {

    // 只有当该Bean缺失时才注入该Bean，避免和用户自定义注入冲突
    @Bean
    @ConditionalOnMissingBean
    public MyConditionalBean myConditionalBean() {
        System.out.println("Inject conditional bean");
        return new MyConditionalBean();
    }

    class MyConditionalBean {
    }
}
