package test04;

import io.unnode.beans.support.*;
import org.junit.Test;
import test04.bean.UserDao;
import test04.bean.UserService;

public class ApiTest {

    @Test
    public void test(){

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册数据传输对象
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 配置业务对象属性
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId","100001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao",new BeanReference("userDao")));

        // 依赖注入
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
