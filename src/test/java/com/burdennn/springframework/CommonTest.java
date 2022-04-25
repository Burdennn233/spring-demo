package com.burdennn.springframework;

import com.burdennn.springframework.bean.UserDao;
import com.burdennn.springframework.bean.UserService;
import com.burdennn.springframework.beans.PropertyValue;
import com.burdennn.springframework.beans.PropertyValues;
import com.burdennn.springframework.beans.factory.config.BeanDefinition;
import com.burdennn.springframework.beans.factory.config.BeanReference;
import com.burdennn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.burdennn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.burdennn.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test_context_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryUserInfo();

        System.out.println("ApplicationContextAware: " + userService.getApplicationContext());
        System.out.println("BeanFactory: " + userService.getBeanFactory());
    }

    @Test
    public void test_Xml() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) beanFactory.getBean("userService", "burdenn");
        userService.queryUserInfo();
    }

    @Test
    public void test_Origin() {
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
