package quickStart.controller;

/**
 * @Description
 * @date 2020/11/13-20:41
 */
public class Person {
    private String lastName;
    private Integer age;
    private String gender;
    private String email;

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
