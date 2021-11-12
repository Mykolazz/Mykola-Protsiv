package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanA;
import com.epam.spring.homework2.beans.BeanE;
import com.epam.spring.homework2.beans.BeanF;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.epam.spring.homework2.beans", includeFilters=
        @ComponentScan.Filter(
                type= FilterType.ASSIGNABLE_TYPE, classes= {BeanA.class, BeanE.class, BeanF.class}))
public class Configuration2 {

        @Bean
        public String nameForBeanA(){
                return "BeanA";
        }
        @Bean
        public String nameForBeanE(){
                return "BeanE";
        }
        @Bean
        public String nameForBeanF(){
                return "BeanF";
        }
        @Bean
        public Integer valueForBeanA(){
                return 69;
        }
        @Bean
        public Integer valueForBeanE(){
                return 73;
        }
        @Bean
        public Integer valueForBeanF(){
                return 74;
        }
}
