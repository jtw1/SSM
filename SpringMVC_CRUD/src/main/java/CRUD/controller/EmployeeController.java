package CRUD.controller;

import CRUD.Bean.Department;
import CRUD.Bean.Employee;
import CRUD.DAO.EmployeeDao;
import CRUD.DAO.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * empinfo=“empAdmin-admin@qq.com-1-101”
     * @RequestParam("empinfo") Employee employee 相当于
     * Employee employee=request.getParameter("empinfo")
     * 但是现在无法将一个字符串转换成employee对象，所以需要写一个自定义类型的转换器让其工作
     * @param employee
     * @return
     */
    @RequestMapping("/quickadd")
    public String quickAdd(@RequestParam("empinfo") Employee employee){
        System.out.println("封装："+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //将员工列表显示在页面
    @RequestMapping("/emps")
    public String getEmployees(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }
    @RequestMapping(value="/emp/{id}",method = RequestMethod.DELETE)
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

    /**
     * 查询员工，来到修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value="/emp/{id}",method = RequestMethod.GET)
    public String getEmp(@PathVariable("id")Integer id,Model model){
        //查出员工信息放在请求域中
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        //继续查出部门信息放在隐含模型中
        Collection<Department> departments = departmentDao.getAllDepartments();
        model.addAttribute("depts",departments);
        return "edit";
    }
    @RequestMapping(value = "/emp/{id}",method = RequestMethod.PUT)
    public String updateEmp(@ModelAttribute("employee") Employee employee){
        System.out.println("要修改的员工信息："+employee);
        //更新保存二合一
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //此方法在每个方法运行之前都会提前运行
    public void myModelAttribute(@RequestHeader(value = "id",required = false)Integer id,Model model){
        if(id!=null){
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
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
    public String addEmp( Employee employee){
        System.out.println("要添加的员工："+employee);
        employeeDao.save(employee);
        //添加完成之后返回列表页面 重定向到查询所有员工的请求
        return "redirect:/emps";
    }
}
