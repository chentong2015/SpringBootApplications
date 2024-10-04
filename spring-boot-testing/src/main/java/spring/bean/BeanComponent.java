package spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

    @Autowired
    private BeanInjection beanInjection;

    // Setter for testing 用于测试时更改Bean中属性
    public void setBeanInjection(BeanInjection beanInjection) {
        this.beanInjection = beanInjection;
    }

    public void printBeanId() {
        int id = this.beanInjection.getId();
        System.out.println(id);
    }
}
