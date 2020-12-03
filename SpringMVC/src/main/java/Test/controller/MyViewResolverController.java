package Test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义视图解析器和视图对象
 * @Description
 * @date 2020/12/3 0003-16:36
 */
@Controller
public class MyViewResolverController {
    @RequestMapping("handlePlus")
    public String handlePlus(Model map){
        List<String> videoName = new ArrayList<>();
        List<String> imgName = new ArrayList<>();
        videoName.add("武藤");
        videoName.add("冲天");
        imgName.add("大桥");
        map.addAttribute("video",videoName);
        map.addAttribute("images",imgName);
        return "meinv:/gq";
    }
}
