package com.burdennn.springframework.aop;

import java.lang.reflect.Method;

public class UserServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] arg, Object target) throws Throwable {
        System.out.println("Before method: " + method.getName());
    }
}
