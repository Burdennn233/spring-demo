package com.burdennn.springframework.beans.factory;

public interface DisposableBean {
    void destroy() throws Exception;
}
