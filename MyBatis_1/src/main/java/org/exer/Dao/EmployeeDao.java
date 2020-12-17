package org.exer.Dao;

import org.exer.Bean.Employee;

/**
 * @Description
 * @date 2020/12/14 0014-20:25
 */
public interface EmployeeDao {
    //按照员工id查询员工
    Employee getEmpById(Integer id);
    int updateEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
    int insertEmployee(Employee employee);
}
