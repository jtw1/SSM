package MVC.service;

import MVC.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @date 2020/11/19-22:57
 */
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public void save(){
        System.out.println("bookService...正在调用dao帮你保存图书");
        bookDao.saveBook();
    }
}
