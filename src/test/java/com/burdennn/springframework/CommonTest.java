package com.burdennn.springframework;

import com.burdennn.springframework.bean.UserService;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test() {
        BeanFactory beanFactory = new BeanFactory();

        beanFactory.registerBeanDefinition("userService", new BeanDefinition(new UserService()));

        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
