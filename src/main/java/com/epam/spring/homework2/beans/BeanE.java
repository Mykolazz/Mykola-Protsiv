package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanE {

    private String name;
    private int value;

    public BeanE(){
        System.out.println("BeanE");
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

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanE: 'I'm dying, help me...'");
    }

    @PostConstruct
    public void afterPropertiesSet(){
        System.out.println("BeanE: 'I arose!'");
    }

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
