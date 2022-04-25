package com.burdennn.springframework.beans.factory;

import com.burdennn.springframework.beans.BeansException;

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
