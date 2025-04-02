package test16;

import io.unnode.context.ClassPathXmlApplicationContext;
import org.junit.Test;
import test16.bean02.IUserService;

public class ApiTest_2 {

    @Test
    public void test_autoProxy_2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring16-2.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
