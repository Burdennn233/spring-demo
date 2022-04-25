package com.burdennn.springframework.beans.factory.support;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {

    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCachedObjectForFactoryBean(String beanName) {
        Object object = this.factoryBeanObjectCache.get(beanName);
        return object == NULL_OBJECT ? null : object;
    }

    protected Object getObjectFromFactoryBean(FactoryBean factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object object = this.factoryBeanObjectCache.get(beanName);
            if (object == null) {
                object = doGetObjectFromFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, object == null ? NULL_OBJECT : object);
            }

            return object == NULL_OBJECT ? null : object;
        } else {
            return doGetObjectFromFactoryBean(factoryBean, beanName);
        }
    }

    protected Object doGetObjectFromFactoryBean(final FactoryBean factoryBean, final String beanName) {
        try {
            return factoryBean.getObject();
        } catch (BeansException e) {
            throw new BeansException("FactoryBean throw exception on object [" + beanName + "] creation", e);
        }
    }

}
