package spring.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MockBeanComponentTest {

    @Autowired
    private BeanInjection beanInjection;

    @Autowired
    private BeanComponent component;

    @Test
    public void testBeanInjection() {
        // 测试Spring自动注入的Bean对象
        System.out.println(this.beanInjection.getId());

        // 测试自定义创建的Bean对象，区别于自动注入容器的Bean
        BeanInjection mockInjection = new BeanInjection();
        mockInjection.setId(100);
        component.setBeanInjection(mockInjection);
        component.printBeanId();

        Assertions.assertTrue(true);
    }
}

