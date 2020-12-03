package Test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @date 2020/11/29-16:58
 */
@RequestMapping("/haha")  //为当前所有方法的请求地址指定一个基准路径
@Controller
public class RequestMappingTestController {
    @RequestMapping("/handle01")
    public String handle01(){
        System.out.println("RequestMappingTestController...");
        return "success";
    }

    //RequestMapping其他属性
    @RequestMapping(value = "/handle02",method = {RequestMethod.POST})
    public String handle02(){
        System.out.println("RequestMappingTestController02...");
        return "success";
    }
    //请求必须包含username，没带都会404
    @RequestMapping(value = "/handle03",params = {"username"})
    public String handle03(){
        System.out.println("RequestMappingTestController-03...");
        return "success";
    }

    @RequestMapping("/toLoginPage")
    public String toLogin(){
        return "login";
    }

}
