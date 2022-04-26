package com.burdennn.springframework.aop;

public class TargetSource {

    private final Object target;

    public TargetSource(Object object) {
        this.target = object;
    }

    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return target;
    }
}
