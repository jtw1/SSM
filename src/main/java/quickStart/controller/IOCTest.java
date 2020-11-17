package quickStart.controller;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import quickStart.Bean.Car;
import quickStart.Bean.Person;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @date 2020/11/13-21:29
 */
public class IOCTest {
    private ApplicationContext ioc=new ClassPathXmlApplicationContext("META-INF/applicationContext2.xml");
    //private ApplicationContext ioc2=new ClassPathXmlApplicationContext("META-INF/applicationContext2.xml");
    @Test
    public void test2(){
        Object bean = ioc.getBean("person");
        System.out.println(bean);
    }
    /*
    实验四：正确为各种属性赋值
     */
    @Test
    public void test4(){
        //对null值测试
        Person bean = (Person) ioc.getBean("person4");
        System.out.println(bean);
        //对引用类型值测试
        System.out.println(bean.getCar());
        //对list类型的值测试
        List<Car> cars=bean.getCars();
        System.out.println(cars);
        //对map类型的值测试
        Map<String,Object> maps=bean.getMaps();
        System.out.println(maps);
        //引用外部map的测试
        Person bean1 = (Person) ioc.getBean("person5");
        System.out.println(bean1.getMaps());
    }
    /*
    实验六：通过继承实现配置信息重用
     */
    @Test
    public void test6(){
        Person bean2 = (Person) ioc.getBean("person6");
        System.out.println(bean2.getCar());
    }

    /*
    实验9：测试bean的作用域，分别创建单实例和多实例的bean*
     */
    @Test
    public void test9(){}

    /*
    实验5：配置通过静态工厂方法创建的bean，实例工厂方法创建的bean，FactoryBean*
    bean的默认创建方式就是框架利用反射new出来的bean实例
     */
    @Test
    public void test5(){
        Object bean = ioc.getBean("car5");
        System.out.println(bean);

        Object bean1 = ioc.getBean("car6");
        System.out.println(bean);

        Object bean2 = ioc.getBean("MyFactoryBeanImple");
        Object bean3 = ioc.getBean("MyFactoryBeanImple");
        System.out.println(bean2==bean3);
    }

    /*
    实验12：构造数据据库连接池
     */
    @Test
    public void test12() throws SQLException {
        DataSource bean = ioc.getBean(DataSource.class);
        System.out.println(bean.getConnection());
    }
}
