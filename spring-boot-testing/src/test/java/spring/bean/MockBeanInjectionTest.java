package spring.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MockBeanInjectionTest {

    // Mock掉Spring Context中注入的Bean对象
    @MockBean
    private BeanInjection beanInjection;

    @Test
    public void testMockBeanInjection() {
        Mockito.when(beanInjection.getId()).thenReturn(100);

        System.out.println(beanInjection.getId());
        Assertions.assertTrue(true);
    }
}
