package Exercise.utils;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 如何将这个类（切面类）中的这些方法（通知方法）动态地运行在目标方法的各个位置
 * @Description  日志功能
 * @date 2020/11/21-16:45
 */
@Component
public class LogUtils {
    //想在执行目标方法之前执行
    @Before("execution(public int Exercise.impl.MathCalculator.*)")
    public static void logStart(Method method,Object...args){
        System.out.println("动态代理将要帮你执行方法");
        System.out.println("["+method.getName()+"]方法开始了，它使用的参数是"+ Arrays.asList(args));
        //System.out.println("xxx方法开始了，它使用的参数是["+objects+"]");
    }
    //想在目标方法正常执行完成之后执行
    @AfterReturning()
    public static void logReturn(Method method,Object result){
        System.out.println("["+method.getName()+"]方法正常执行完成，执行结果是["+ result+"]");
    }

    //想在目标方法出现异常时执行
    @AfterThrowing()
    public static void logException(Method method,Exception e){
        System.out.println("["+method.getName()+"方法执行出现异常了，异常情况是["+ e.getCause()+"]");
    }

    //想在目标方法结束时执行
    public static void logFinish(Method method){
        System.out.println("["+method.getName()+"]方法最终结束了");
    }
}
