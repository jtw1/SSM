package CRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description
 * @date 2020/12/3 0003-20:40
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String handle01(){
        return "success";
    }
}
