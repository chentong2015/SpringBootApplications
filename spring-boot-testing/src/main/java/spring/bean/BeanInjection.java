package spring.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanInjection {

    private int id = 10;

    public BeanInjection() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
