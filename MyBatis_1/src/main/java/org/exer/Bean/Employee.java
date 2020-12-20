package org.exer.Bean;

import java.io.Serializable;

/**
 * @Description
 * @date 2020/12/14 0014-20:21
 */
public class Employee implements Serializable {
    private Integer id;
    private String empName;
    private Integer gender;
    private String email;

    public Employee() {
    }

    public Employee(Integer id, String empName, Integer gender, String email) {
        this.id = id;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }
}
