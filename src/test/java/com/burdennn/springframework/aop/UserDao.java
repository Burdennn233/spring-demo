package com.burdennn.springframework.aop;

import com.burdennn.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDao {

    private static Map<String, String> map = new HashMap<>();

    static {
        map.put("burdennn", "001");
    }

    public String queryUserName(String name) {
        return map.get(name);
    }

}
