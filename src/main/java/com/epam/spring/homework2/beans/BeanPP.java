package com.epam.spring.homework2.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BeanPP implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof GenericBean){
            GenericBean castedBean = (GenericBean) bean;
            if(castedBean.getName() == null){
                castedBean.setName(castedBean.getClass().getSimpleName());
            }
            if (castedBean.getValue() <= 0){
                castedBean.setValue((int) ((Math.random()*100+1)));
            }
        }
        return bean;
    }
}
