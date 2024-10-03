package spring.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanComponent {

    private BeanInjection beanInjection;

    public void setBeanInjection(BeanInjection beanInjection) {
        this.beanInjection = beanInjection;
    }

    public void printBeanId() {
        int id = this.beanInjection.getId();
        System.out.println(id);
    }
}
