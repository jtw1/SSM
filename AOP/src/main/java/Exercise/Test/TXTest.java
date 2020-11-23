package Exercise.Test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description JdbcTemplate使用
 * @date 2020/11/22-18:41
 */
public class TXTest {
    ApplicationContext ioc4=new ClassPathXmlApplicationContext("conf/ApplicationContextAOP.xml");
    //JdbcTemplate jdbcTemplate=new JdbcTemplate();
    @Test
    public void test() throws SQLException {
        DataSource dataSource = ioc4.getBean(DataSource.class);
        Connection connection=dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test1(){
        JdbcTemplate jdbcTemplate = ioc4.getBean(JdbcTemplate.class);
        System.out.println(jdbcTemplate);
    }
}
