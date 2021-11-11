package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Import(Configuration2.class)
@PropertySource("bean_prop.properties")
@ComponentScan(basePackages = "com.epam.spring.homework2.beans", excludeFilters=
        @ComponentScan.Filter(
                type=FilterType.ASSIGNABLE_TYPE, classes= {BeanA.class, BeanE.class, BeanF.class}))
public class Configuration1 {




}
