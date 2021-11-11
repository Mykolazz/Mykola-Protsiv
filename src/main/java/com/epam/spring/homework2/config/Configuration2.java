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

}
