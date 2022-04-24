package com.burdennn.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.DisposableBean;
import com.burdennn.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private final String beanName;

    private final Object bean;

    private String destroyMethodName;

    public DisposableBeanAdapter(String beanName, Object bean, BeanDefinition beanDefinition) {
        this.beanName = beanName;
        this.bean = bean;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (method == null) {
                throw new BeansException("Count not find a destroy method named '" + destroyMethodName + "' on bean with name " + beanName);
            }
            method.invoke(bean);
        }
    }
}
