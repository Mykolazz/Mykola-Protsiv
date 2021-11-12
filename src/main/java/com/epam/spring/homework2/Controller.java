package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.BeanC;
import com.epam.spring.homework2.beans.BeanF;
import com.epam.spring.homework2.config.Configuration1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Controller {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Configuration1.class);

        BeanC beanC = context.getBean("beanC", BeanC.class);
        System.out.println(beanC.getName() + " " + beanC.getValue());
        context.getBean("beanF", BeanF.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("List of all beans from ApplicationContext:");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        context.close();
    }
}
