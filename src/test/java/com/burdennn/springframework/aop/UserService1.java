package com.burdennn.springframework.aop;

import com.burdennn.springframework.beans.factory.annotation.Autowired;
import com.burdennn.springframework.beans.factory.annotation.Value;
import com.burdennn.springframework.stereotype.Component;

import java.util.Random;

@Component("userService1")
public class UserService1 implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "queryUserInfo with token: " + token;
    }

    @Override
    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Register " + userDao.queryUserName(userName);
    }
}
