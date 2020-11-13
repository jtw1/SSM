package quickStart.controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @Description
 * @date 2020/11/12 0012-22:09
 */
public class main {
    public static void main(String[] args) {
        //HelloWord he = new HelloWord();

        //1.创建spring的ioc容器对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        //2.从ioc容器中获取bean实例
        HelloWord helloWorld = (HelloWord) ctx.getBean("helloWorld");
        helloWorld.hello();
    }
}
