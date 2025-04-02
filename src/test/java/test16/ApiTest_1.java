package test16;

import io.unnode.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import test16.bean01.IUserService;

public class ApiTest_1 {

    @Test
    public void test_autoProxy_1() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring16-1.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

}