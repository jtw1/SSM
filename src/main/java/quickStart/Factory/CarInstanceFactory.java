package quickStart.Factory;

import quickStart.Bean.Car;

/**
 * @Description car的实例工厂
 * @date 2020/11/15-19:37
 */
public class CarInstanceFactory {
    public Car getCar(String carName){
        System.out.println("实例工厂正在造车");
        Car car=new Car();
        car.setCarName("hiaer");
        car.setColor("green");
        car.setPrice(5000000);
        return car;
    }
}
