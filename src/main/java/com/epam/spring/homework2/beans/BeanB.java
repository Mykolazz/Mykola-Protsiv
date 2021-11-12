package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class BeanB extends GenericBean {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    private void init(){
        System.out.println("'beanB' bean initialization");
    }

    private void alternativeInit(){
        System.out.println("Alternative 'beanB' bean initialization");
    }

    private void preDestroy(){
        System.out.println("Destroying bean 'beanB'");
    }

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
