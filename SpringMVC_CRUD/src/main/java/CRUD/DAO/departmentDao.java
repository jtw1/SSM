package CRUD.DAO;

import CRUD.Bean.Department;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @date 2020/12/3 0003-21:07
 */
public class departmentDao {
    private static Map<Integer, Department> departments=null;

    static{
        departments=new HashMap<>();

        departments.put(101,new Department(101,"D-AA"));
        departments.put(102,new Department(102,"D-BB"));
        departments.put(103,new Department(103,"D-CC"));
        departments.put(104,new Department(104,"D-DD"));
        departments.put(105,new Department(105,"D-EE"));
    }

    public Collection<Department> getDepartment(){
        return departments.values();
    }
}
