package quickStart.Factory;

import quickStart.Bean.Car;
/**
 * @Description Car的静态工厂
 * @date 2020/11/15-19:39
 */
public class CarStaticFactory {
    public static Car getCar(String carName){
        System.out.println("静态工厂正在造车");
        Car car=new Car();
        car.setColor("green");
        car.setPrice(5000000);
        return car;
    }
}
