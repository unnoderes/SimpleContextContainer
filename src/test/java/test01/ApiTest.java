package test01;

import io.unnode.beans.support.BeanDefinition;
import io.unnode.beans.support.DefaultListableBeanFactory;
import org.junit.Test;
import test02.bean.UserService;

public class ApiTest {

    @Test
    public void test(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 从单例池取
        UserService userService_s = (UserService)beanFactory.getSingleton("userService");
        userService_s.queryUserInfo();
    }
}
