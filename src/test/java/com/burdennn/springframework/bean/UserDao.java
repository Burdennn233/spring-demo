package com.burdennn.springframework.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("burdennn", "001");
    }

    public String getUserName(String name) {
        return map.get(name);
    }

    public void init() {
        System.out.println("Init UserDao");
        map.put("init", "003");
    }

    public void destroyUserDao() {
        System.out.println("Destory UserDao");
        map.clear();
    }
}
