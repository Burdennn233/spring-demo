package com.burdennn.springframework.beans.factory;

public interface InitializingBean {
    void afterPropertiesSet() throws Exception;
}
