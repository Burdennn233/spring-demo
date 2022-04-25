package com.burdennn.springframework.beans.factory;

import com.burdennn.springframework.beans.BeansException;

public interface FactoryBean<T> {

    T getObject() throws BeansException;

    Class<?> getObjectType();

    boolean isSingleton();
}
