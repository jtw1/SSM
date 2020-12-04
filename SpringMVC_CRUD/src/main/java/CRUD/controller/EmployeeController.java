package CRUD.controller;

import CRUD.Bean.Department;
import CRUD.Bean.Employee;
import CRUD.DAO.EmployeeDao;
import CRUD.DAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @Description
 * @date 2020/12/4 0004-15:02
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //将员工列表显示在页面
    @RequestMapping("/emps")
    public String getEmployees(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }
    //去员工添加页面,去页面之前需要查出所有部门信息进行展示
    @RequestMapping("/toaddpage")
    public String toAddPage(Model model){
        //先查出所有部门
        Collection<Department> departments = departmentDao.getAllDepartments();
        //放在请求域中
        model.addAttribute("depts",departmentDao);
        model.addAttribute("employee",new Employee(null,"账号三","haha@163.com",0,departmentDao.getDepartment(101)));
        //去添加页面
        return "add";
    }
    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    public String addEmp(Employee employee){
        System.out.println("要添加的员工："+employee);
        employeeDao.save(employee);
        //添加完成之后返回列表页面 重定向到查询所有员工的请求
        return "redirect:/emps";
    }
}
