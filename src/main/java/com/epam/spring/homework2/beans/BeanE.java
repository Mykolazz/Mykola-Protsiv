package com.epam.spring.homework2.beans;

import org.springframework.stereotype.Component;

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

    @Override
    public String toString() {
        return "BeanE{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
