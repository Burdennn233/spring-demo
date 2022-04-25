package com.burdennn.springframework.context.support;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.ApplicationContextAware;
import com.burdennn.springframework.beans.factory.config.BeanPostProcessor;
import com.burdennn.springframework.context.ApplicationContext;

public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }

        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
