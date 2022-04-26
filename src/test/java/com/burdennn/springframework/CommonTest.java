package com.burdennn.springframework;

import com.burdennn.springframework.aop.AdvisedSupport;
import com.burdennn.springframework.aop.IUserService;
import com.burdennn.springframework.aop.TargetSource;
import com.burdennn.springframework.aop.UserServiceInterceptor;
import com.burdennn.springframework.aop.aspectj.AspectJExpressionPointcut;
import com.burdennn.springframework.aop.framework.Cglib2AopProxy;
import com.burdennn.springframework.aop.framework.JdkDynamicAopProxy;
import com.burdennn.springframework.bean.ProxyBeanFactory;
import com.burdennn.springframework.bean.UserDao;
import com.burdennn.springframework.bean.UserService;
import com.burdennn.springframework.beans.PropertyValue;
import com.burdennn.springframework.beans.PropertyValues;
import com.burdennn.springframework.beans.factory.FactoryBean;
import com.burdennn.springframework.beans.factory.config.BeanDefinition;
import com.burdennn.springframework.beans.factory.config.BeanReference;
import com.burdennn.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.burdennn.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.burdennn.springframework.context.support.ClassPathXmlApplicationContext;
import com.burdennn.springframework.event.CustomEvent;
import org.junit.Test;

public class CommonTest {

    @Test
    public void test_aop() {
        IUserService userService = new com.burdennn.springframework.aop.UserService();
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* com.burdennn.springframework.aop.IUserService.*(..))"));

        IUserService proxyJDK = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        System.out.println(proxyJDK.queryUserInfo());

        IUserService proxyCglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        System.out.println(proxyCglib.register("burdennn"));
        System.out.println(proxyCglib.queryUserInfo());

    }

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
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 123L, "message"));

        applicationContext.registerShutdownHook();
    }

    @Test
    public void test_factory_bean() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");
        applicationContext.registerShutdownHook();

        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.queryIUserInfo();
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
