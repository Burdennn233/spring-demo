package com.burdennn.springframework.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
