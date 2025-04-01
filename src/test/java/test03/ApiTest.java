package test03;

import io.unnode.beans.support.BeanDefinition;
import io.unnode.beans.support.DefaultListableBeanFactory;
import org.junit.Test;
import test03.bean.UserService;

public class ApiTest {

    @Test
    public void test(){
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService",beanDefinition);
        UserService userService = (UserService)beanFactory.getBean("userService","unnode");
        userService.queryUserInfo();
    }
}
