package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanD {
    @Value("${beanD.name}")
    private String name;
    @Value("${beanD.value}")
    private int value;

    public BeanD(){
        System.out.println("BeanD");
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private void init(){
        System.out.println("Initialization bean: type: " + BeanB.class.getSimpleName() + "name:" + name);
    }

    private void preDestroy(){
        System.out.println("Destroying bean: type: " + BeanB.class.getSimpleName() + "name:" + name);
    }

    @Override
    public String toString() {
        return "BeanD{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
