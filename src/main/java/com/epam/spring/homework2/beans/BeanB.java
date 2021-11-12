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
    private static int counter = 0;

    public BeanB(){
        System.out.println("BeanB " + counter++);
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
        return "BeanB{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
