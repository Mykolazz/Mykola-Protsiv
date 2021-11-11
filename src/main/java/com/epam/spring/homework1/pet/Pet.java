package com.epam.spring.homework1.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Pet {

    List<Animal> animalList;

    @Autowired
    public Pet(List<Animal> animalList){
        this.animalList = new ArrayList<>(animalList);
    }

    public void printPets(){
        for (Animal animal : animalList){
            System.out.println(animal.getClass().getSimpleName());
        }
    }
}
