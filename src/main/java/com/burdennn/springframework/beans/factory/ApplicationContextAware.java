package com.burdennn.springframework.beans.factory;

import com.burdennn.springframework.beans.BeansException;
import com.burdennn.springframework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
