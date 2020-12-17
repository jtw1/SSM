package MyBatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.exer.Bean.Employee;
import org.exer.Dao.EmployeeDao;
import org.junit.Before;
import org.junit.Test;
import scala.io.BytePickle;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @date 2020/12/14 0014-21:12
 */
public class TestForMyBatis {
    //多线程模式下工厂只需要一个就行了
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void initSqlSessionFactory() throws IOException {
        //1 根据全局配置文件创建出一个SqlSessionFactory(SqlSession的工厂，负责创建SqlSession对象)
        //SqlSession：代表和数据库的一次会话
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    //增加
    @Test
    public void testInsert(){
        //获取和数据库的一次会话
        //openSession函数形参为true:自动提交   false：需要sqlSession.commit();手动提交
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            Employee employee = new Employee(null, "tomcat", 1, "tomecat@qq.com");
            int i=mapper.insertEmployee(employee);
            System.out.println(i);
            sqlSession.commit();
            System.out.println("刚才插入的员工id："+employee.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //手动提交
            //sqlSession.commit();
            //关闭资源
            sqlSession.close();
        }
    }
    //删除
    @Test
    public void testDel(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            boolean res = mapper.deleteEmployee(7);
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    //更改
    @Test
    public void testUpdate(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        try {
            EmployeeDao mapper = sqlSession.getMapper(EmployeeDao.class);
            int res=mapper.updateEmployee(new Employee(6,"tom",0,"Alibaba@qq.com"));
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    //测试查询
    @Test
    public void testSearch() {
        //initSqlSessionFactory();
        Employee employee = null;
        //2 获取和数据库的一次会话
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3,使用SqlSession操作数据库，获取到dao接口的实现(映射器)
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            employee = employeeDao.getEmpById(2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        System.out.println(employee);
    }
}
