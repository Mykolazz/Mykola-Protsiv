package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn(value = {"beanB", "beanD"})
public class BeanC {
    @Value("${beanC.name}")
    private String name;
    @Value("${beanC.value}")
    private int value;

    public BeanC(){
        System.out.println("BeanC");
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
        return "BeanC{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
