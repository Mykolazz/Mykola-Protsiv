package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
 Я додав для цього біна init та destroy методи для того,
 щоб поспостерігати за його поведінкою. Оскільки він позначений
 анотацією @Lazy та всеодно попадає в ApplicationContext, тому мені було цікаво.
 */

@Lazy
@Component
@DependsOn({"nameForBeanF", "valueForBeanF"})
public class BeanF extends GenericBean {

    private String name;
    private int value;


    @Override
    @Autowired
    @Qualifier("nameForBeanF")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    @Autowired
    @Qualifier("valueForBeanF")
    public void setValue(Integer value) {
        this.value = value;
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("BeanF: 'I'm dying, help me...'");
    }

    @PostConstruct
    public void afterPropertiesSet(){
        System.out.println("BeanF: 'I arose!'");
    }

    @Override
    public String toString() {
        return "BeanF{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
