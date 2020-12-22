package org.exer.Dao;

import org.exer.Bean.Employee;

import java.util.List;

/**
 * @Description
 * @date 2020/12/14 0014-20:25
 */
public interface EmployeeDao {
    public List<Employee> getAllEmps();
    //按照员工id查询员工
    Employee getEmpById(Integer id);
    int updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
    int insertEmployee(Employee employee);
}
