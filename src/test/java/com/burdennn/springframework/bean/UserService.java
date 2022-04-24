package com.burdennn.springframework.bean;

import com.burdennn.springframework.beans.factory.DisposableBean;
import com.burdennn.springframework.beans.factory.InitializingBean;

public class UserService implements InitializingBean, DisposableBean {

    private String name;

    private String location;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("UserInfo: " + name + "location: " + location);
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
}
