package spring.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanComponentTest {

    @Autowired
    private BeanInjection beanInjection;

    @Autowired
    private BeanComponent component;

    // 通过Setter注入新的Bean对象用于测试，区别于自动注入容器的Bean
    @Test
    public void testBeanInjection() {
        System.out.println(this.beanInjection.getId());

        BeanInjection mockInjection = new BeanInjection();
        mockInjection.setId(100);
        component.setBeanInjection(mockInjection);
        component.printBeanId();
        Assertions.assertTrue(true);
    }
}

