package MVC.servlet;

import MVC.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @date 2020/11/19-22:55
 */
@Controller
public class BookServlet {
    //自动装配
    @Autowired
    private BookService bookService;
    public void doGet(){
        bookService.save();
    }
}
