package Exercise.Test;

import Exercise.impl.MathCaculator;
import Exercise.inter.Caculator;
import Proxy.CaculatorProxy;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description
 * @date 2020/11/21-16:42
 */
public class AOPTest {
    ApplicationContext ioc=new ClassPathXmlApplicationContext("conf/ApplicationContextAOP.xml");


    @Test
    public void test(){
        Caculator caculator=new MathCaculator();
        caculator.add(1,2);
        System.out.println("-----------");

        //利用代理对象进行计算
        Caculator proxy = CaculatorProxy.getProxy(caculator);
        proxy.add(1,2);
        //proxy.div(2,0);
    }

    @Test
    public void test1(){
        //从IOC容器中拿到目标对象，注意，如果想要用类型，一定要用他的接口类型，不要用它的本类
    }

    //JdbcTemplate使用
    @Test
    public void test2(){

    }
}
