package com.burdennn.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.PropertyValue;
import com.burdennn.springframework.beans.PropertyValues;
import com.burdennn.springframework.beans.factory.config.BeanDefinition;
import com.burdennn.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract  class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;

        try {
            bean = createBeanInstance(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor ctorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?>[] constructors = beanClass.getDeclaredConstructors();
        for (Constructor ctor : constructors) {
            if (args != null && ctor.getParameterTypes().length == args.length) {
                ctorToUse = ctor;
                break;
            }
        }
        return getInstantiationStrategy().instantiate(beanDefinition, beanName, ctorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue pv : propertyValues.getPropertyValues()) {
                String name = pv.getName();
                Object value = pv.getValue();
                if (value instanceof BeanReference) {
                    value = getBean(((BeanReference) value).getBeanName());
                }

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (BeansException e) {
            throw new BeansException("Error setting property values: " + beanName);
        }
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
