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
}
