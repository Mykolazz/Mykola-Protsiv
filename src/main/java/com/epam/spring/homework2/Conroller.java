package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.config.Configuration1;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Conroller {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);

        BeanC beanC = context.getBean("beanC", BeanC.class);
        System.out.println(beanC.getName() + " " + beanC.getValue());
        context.getBean("beanF", BeanF.class);
    }
}
