package com.daun.industries.evgenyborisov.postprocessors;

import com.daun.industries.evgenyborisov.quoters.annotations.InjectRandomInt;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;

public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
            if(annotation != null){
                int max = annotation.max();
                int min = annotation.min();
                Random random = new Random();
                int randomInt = min+random.nextInt(max - min);
                declaredField.setAccessible(true);
                ReflectionUtils.setField(declaredField, bean, randomInt);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
