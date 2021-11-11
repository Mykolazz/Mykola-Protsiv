package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = "beanD")
public class BeanB {
    @Value("${beanB.name}")
    private String name;
    @Value("${beanB.value}")
    private int value;

    public BeanB(){
        System.out.println("BeanB");
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

    @Override
    public String toString() {
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
