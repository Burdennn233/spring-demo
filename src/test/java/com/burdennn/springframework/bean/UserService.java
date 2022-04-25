package com.burdennn.springframework.bean;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.beans.factory.*;
import com.burdennn.springframework.context.ApplicationContext;

public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    private String name;

    private String location;

    private UserDao userDao;

    private IUserDao iUserDao;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("UserInfo: " + name + "location: " + location);
    }

    public void queryIUserInfo() {
        System.out.println("UserInfo: " + iUserDao.queryUserInfo(name));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy UserService");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet UserService");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader is " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is :" + name);
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
