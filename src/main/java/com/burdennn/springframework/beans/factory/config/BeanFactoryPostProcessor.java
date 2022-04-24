package com.burdennn.springframework.beans.factory.config;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.ConfigurableListableBeanFactory;

public interface BeanFactoryPostProcessor {

    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
