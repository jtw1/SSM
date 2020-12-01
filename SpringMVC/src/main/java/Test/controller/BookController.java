package Test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description
 * @date 2020/11/30 0030-19:25
 */
@Controller
public class BookController {
    //处理查询图书请求
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.GET)
    public String addBook(@PathVariable("bid") Integer id){
        System.out.println("查询到了"+id+"号图书");
        return "success";
    }

    //处理删除图书请求
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("bid") Integer id){
        System.out.println("删除了"+id+"号图书");
        return "success";
    }

    //处理更新图书请求
    @RequestMapping(value = "/book/{bid}",method = RequestMethod.PUT)
    public String updateBook(@PathVariable("bid") Integer id){
        System.out.println("更新了"+id+"号图书");
        return "success";
    }


    //处理添加图书请求
    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String getBook(){
        System.out.println("添加了新的图书");
        return "success";
    }
}
