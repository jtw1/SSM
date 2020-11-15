package quickStart.Bean;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @date 2020/11/13-20:41
 */
public class Person {
    private String lastName;
    private Integer age;
    private String gender;
    private String email;

    private Car car;
    private List<Car> cars;
    private Map<String,Object> maps;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }



    public Person() {
        super();
        System.out.println("person创建了");
    }

    public Person(String lastName, Integer age, String gender, String email) {
        super();
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        System.out.println("有参person创建了");
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
