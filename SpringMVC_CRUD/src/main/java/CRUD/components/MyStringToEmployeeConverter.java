package CRUD.components;

import CRUD.Bean.Employee;
import CRUD.DAO.DepartmentDao;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * 将S转化为T
 * S的格式 “empAdmin-admin@qq.com-1-101”
 * @Description
 * @date 2020/12/7 0007-11:30
 */
public class MyStringToEmployeeConverter implements Converter<String, Employee> {

    @Autowired
    DepartmentDao departmentDao;

    /**
     * 自定义转换规则   String->employee
     * @param source
     * @return
     */
    @Override
    public Employee convert(String source) {
        System.out.println("页面提交的将要转换的字符串"+source);
        Employee employee = new Employee();
        if(source.contains("-")){
            String[] split=source.split("-");
            employee.setLastName(split[0]);
            employee.setEmail(split[1]);
            employee.setGender(Integer.parseInt(split[2]));
            employee.setDepartment(departmentDao.getDepartment(Integer.parseInt(split[3])));
        }
        return employee;
    }
}
