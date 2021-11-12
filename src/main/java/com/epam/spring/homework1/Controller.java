package com.epam.spring.homework1;

import com.epam.spring.homework1.config.BeanConfig;
import com.epam.spring.homework1.pet.Cheetah;
import com.epam.spring.homework1.pet.Pet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Controller {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Pet pet = context.getBean("pet", Pet.class);
        pet.printPets();

        Cheetah cheetah = context.getBean("cheetah", Cheetah.class);
        Cheetah cheetah1 = context.getBean("cheetah1", Cheetah.class);
        Cheetah thirdCheetah = context.getBean("thirdCheetah", Cheetah.class);
        System.out.println("\n" + cheetah + "\n" +  cheetah1 + " — '@Primary' \n" + thirdCheetah);
        System.out.println(context.getBean(Cheetah.class));
    }
}
