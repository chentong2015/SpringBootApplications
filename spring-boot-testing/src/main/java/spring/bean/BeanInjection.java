package spring.bean;

import org.springframework.stereotype.Component;

@Component
public class BeanInjection {

    private int id;

    public BeanInjection(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
