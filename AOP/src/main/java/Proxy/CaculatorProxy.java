package Proxy;

import Exercise.inter.Caculator;
import Exercise.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Description 帮Caculator生成代理对象的类
 * @date 2020/11/21-16:56
 */
public class CaculatorProxy {
    /**
     * 为传入的参数对象创建一个动态代理对象  (动态代理)
     * @param caculator 被代理对象
     * @return 代理对象
     */
    public static Caculator getProxy(Caculator caculator){
        ClassLoader loader = caculator.getClass().getClassLoader();  //被代理对象的类加载器
        Class<?>[] interfaces = caculator.getClass().getInterfaces(); //被代理对象的类实现的接口
        InvocationHandler h = new InvocationHandler() {
            @Override
            /**
             * proxy: 代理对象 供JDK使用，任何时候都不要动这个对象
             * method:当前要执行的目标对象的方法
             * args：方法调用时外界传入的参数值
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //利用反射执行目标方法
                Object result = null;  //目标方法执行后的返回值
                try {
                    LogUtils.logStart(method,args);
                    result = method.invoke(caculator, args);
                    LogUtils.logReturn(method,result);
                } catch (Exception e) {
                    LogUtils.logException(method,e);
                }finally {
                    LogUtils.logFinish(method);
                }
                //返回值必须返回出外界才能拿到真正执行后的返回值
                return result;
            }
        };   //方法执行器，帮目标对象执行目标方法
        Object proxy = Proxy.newProxyInstance(loader, interfaces, h);
        return (Caculator) proxy;
    }
}
