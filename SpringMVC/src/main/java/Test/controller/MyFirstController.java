package Test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1 告诉springMVC这是一个处理器，可以处理请求  @Controller 标识哪个组件是控制器
 * @Description
 * @date 2020/11/26 0026-20:36
 */
@Controller
public class MyFirstController {
    //  /代表从当前项目开始，处理当前项目下的hello请求
    @RequestMapping("/hello")
    public String myFirstRequest(){
        System.out.println("请求收到了，正在处理中...");
//        <property name="prefix" value="/WEB-INF/pages/"></property>
//        <property name="suffix" value=".jsp"></property>
        //拼接为 /WEB-INF/pages/+返回值（success）+.jsp
        return "success";
    }
}
