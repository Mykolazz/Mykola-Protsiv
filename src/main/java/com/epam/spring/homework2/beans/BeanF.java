package com.epam.spring.homework2.beans;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanF {

    private String name;
    private int value;

    public BeanF(){
        System.out.println("BeanF");
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
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
