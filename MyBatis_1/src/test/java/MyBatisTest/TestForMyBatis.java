package MyBatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.exer.Bean.Employee;
import org.exer.Dao.EmployeeDao;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @date 2020/12/14 0014-21:12
 */
public class TestForMyBatis {
    @Test
    public void test() throws IOException {
        //1 根据全局配置文件创建出一个SqlSessionFactory(SqlSession的工厂，负责创建SqlSession对象)
        //SqlSession：代表和数据库的一次会话
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Employee employee = null;
        //2 获取和数据库的一次会话
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            //3,使用SqlSession操作数据库，获取到dao接口的实现
            EmployeeDao employeeDao = openSession.getMapper(EmployeeDao.class);
            employee = employeeDao.getEmpById(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        System.out.println(employee);
    }
}
