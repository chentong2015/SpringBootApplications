package spring.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BeanComponentTest {

    @Autowired
    private BeanComponent beanComponent;

    public BeanComponentTest() {
        BeanInjection beanInjection = new BeanInjection(10);
        this.beanComponent.setBeanInjection(beanInjection);
    }

    @Test
    public void testBeanInjection() {
        beanComponent.printBeanId();
        Assertions.assertTrue(true);
    }
}

