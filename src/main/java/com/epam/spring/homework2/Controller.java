package com.epam.spring.homework2;

import com.epam.spring.homework2.beans.GenericBean;
import com.epam.spring.homework2.config.Configuration1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Controller {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext(Configuration1.class);

       System.out.println("\n" + "*************************"
               + "\n" + "List of all beans from ApplicationContext:"
               + "\n");
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println("\n" + "*************************" + "\n"
                + "End of list of all beans from ApplicationContext"
                + "\n");

        System.out.println("\n" + "*************************" + "\n"
                + "List with parameters of created beans (marked from A to F)"
                + "\n");
        for (String beanName : context.getBeanDefinitionNames()){
            if (context.getBean(beanName) instanceof GenericBean){
                System.out.println(context.getBean(beanName) +
                        System.lineSeparator());
            }
        }
        System.out.println("*************************" + "\n");
        // context.getBean(BeanF.class);
        context.close();

    }
}
