package com.burdennn.springframework.beans.factory.support;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
