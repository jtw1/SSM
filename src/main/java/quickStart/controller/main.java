package quickStart.controller;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Description
 * @date 2020/11/12 0012-22:09
 */
public class main {
    //private ApplicationContext ioc=new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
    //实验二 根据bean的类型从ioc容器获取bean的实例
//    @Test
//    public void test02(){
//        HelloWord bean1 = ioc.getBean(HelloWord.class);
//        bean1.hello();
//    }

    public static void main(String[] args) {
        //HelloWord he = new HelloWord();

        //1.创建spring的ioc容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        //2.从ioc容器中获取bean实例
        HelloWord helloWorld = (HelloWord) ctx.getBean("helloWorld");
        helloWorld.hello();
        System.out.println();
        /*报异常 NoUniqueBeanDefinitionException
        HelloWord bean1 = ctx.getBean(HelloWord.class);*/
        HelloWord bean1 = ctx.getBean("helloWorld1",HelloWord.class);
        bean1.hello();
        System.out.println();
        HelloWord helloWorld2 = (HelloWord)ctx.getBean("helloWorld2");
        helloWorld2.hello();

        Object bean = ctx.getBean("person");
        System.out.println(bean);

    }
}
