package quickStart.controller;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @date 2020/11/13-21:29
 */
public class IOCTest {
    private ApplicationContext ioc=new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
    @Test
    public void test2(){
        Object bean = ioc.getBean("person");
        System.out.println(bean);
    }
}
