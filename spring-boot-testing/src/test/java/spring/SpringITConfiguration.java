package spring;

import org.springframework.boot.autoconfigure.jmx.ParentAwareNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.annotation.AnnotationJmxAttributeSource;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;

// TODO. 配置同一次测试中启动两个Spring boot应用
// 将启动的App组成一个RuleChain: 模拟作为client端(内层启动)+Server端(提供Controller)
@Configuration
public class SpringITConfiguration {

    @Bean
    ObjectNamingStrategy objectNamingStrategy() {
        ParentAwareNamingStrategy strategy = new ParentAwareNamingStrategy(new AnnotationJmxAttributeSource());
        strategy.setEnsureUniqueRuntimeObjectNames(true);
        return strategy;
    }
}
