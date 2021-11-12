package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.context.annotation.*;

@Configuration
@Import(Configuration2.class)
@PropertySource("bean_prop.properties")
@ComponentScan(basePackages = "com.epam.spring.homework2.beans", excludeFilters=
        @ComponentScan.Filter(
                type=FilterType.ASSIGNABLE_TYPE, classes= {BeanA.class, BeanE.class, BeanF.class}))
public class Configuration1 {

        @Bean(initMethod = "init", destroyMethod = "preDestroy")
        public BeanB beanB(){
                return new BeanB();
        }

        @Bean(initMethod = "init", destroyMethod = "preDestroy")
        public BeanC beanC(){
                return new BeanC();
        }

        @Bean(initMethod = "init", destroyMethod = "preDestroy")
        public BeanD beanD(){
                return new BeanD();
        }

}
