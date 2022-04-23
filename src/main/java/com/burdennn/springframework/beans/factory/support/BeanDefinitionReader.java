package com.burdennn.springframework.beans.factory.support;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.core.io.Resource;
import com.burdennn.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
