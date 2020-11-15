package quickStart.Factory;

import org.springframework.beans.factory.FactoryBean;
import quickStart.Bean.Car;

import java.awt.print.Book;
import java.util.UUID;

/**
 * @Description 实现了FactoryBean接口的类是spring可以认识的工厂类
 * spring会自动调用工厂方法创建实例
 * @date 2020/11/15-20:50
 */
public class MyFactoryBeanImple implements FactoryBean<Car> {
    @Override
    //工厂方法
    public Car getObject() throws Exception {
        System.out.println("MyFactoryBeanImple帮你创建对象。。。");
        Car car=new Car();
        car.setCarName(UUID.randomUUID().toString());
        return car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    //false 不是单例
    //true  是单例
    public boolean isSingleton() {
        return true;
    }
}
