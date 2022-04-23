package com.burdennn.springframework;

import com.burdennn.springframework.bean.UserDao;
import com.burdennn.springframework.bean.UserService;
import com.burdennn.springframework.beans.PropertyValue;
import com.burdennn.springframework.beans.PropertyValues;
import com.burdennn.springframework.beans.factory.config.BeanDefinition;
import com.burdennn.springframework.beans.factory.BeanFactory;
import com.burdennn.springframework.beans.factory.config.BeanReference;
import com.burdennn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "burdennn"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));

        UserService userService = (UserService) beanFactory.getBean("userService", "burdennn");
        userService.queryUserInfo();

        UserService userService1 = (UserService) beanFactory.getBean("userService");
        userService1.queryUserInfo();
    }
}
