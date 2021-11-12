package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn({"nameForBeanA", "valueForBeanA"})
public class BeanA extends GenericBean implements InitializingBean, DisposableBean {
    private String name;
    private int value;

    @Override
    @Autowired
    @Qualifier("nameForBeanA")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Autowired
    @Qualifier("valueForBeanA")
    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanA: 'I'm dying, help me...'");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanA: 'I arose!'");
    }

    @Override
    public String toString() {
        return "BeanA{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
