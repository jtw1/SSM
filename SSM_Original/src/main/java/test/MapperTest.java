
import Dao.DepartmentMapper;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description 测试dao层的工作
 * 推荐使用spring的单元测试，可以自动注入我们需要的组件
 * 1 导入springTest模块
 * 2 @ContextConfiguration指定spring配置文件的位置
 * 3 直接@Autowire要使用的组件即可
 * @date 2020/12/28 0028-19:36
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    //测试departmentMapper
    @Test
    public void test1(){
        System.out.println(departmentMapper);
    }
    public void test(){
//        ApplicationContext ioc=new ClassPathXmlApplicationContext("SSM_Original/src/main/resources/applicationContext.xml");
//        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        System.out.println(departmentMapper);
    }
}
