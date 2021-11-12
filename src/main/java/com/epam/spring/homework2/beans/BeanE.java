package com.epam.spring.homework2.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@DependsOn({"nameForBeanE", "valueForBeanE"})
public class BeanE extends GenericBean {

    private String name;
    private int value;

    @Autowired
    @Qualifier("nameForBeanE")
    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    @Qualifier("valueForBeanE")
    public void setValue(Integer value) {
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
