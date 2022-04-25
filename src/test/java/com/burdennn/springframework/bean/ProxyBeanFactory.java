package com.burdennn.springframework.bean;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ProxyBeanFactory implements FactoryBean<IUserDao> {
    @Override
    public IUserDao getObject() throws BeansException {
        InvocationHandler handler = ((proxy, method, args) -> {
            Map<String, String> map = new HashMap<>();
            map.put("burdennn", "proxy001");
            map.put("sz", "002");
            return "Proxy " + method.getName()  + ": " + map.get(args[0].toString());
        });

        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
