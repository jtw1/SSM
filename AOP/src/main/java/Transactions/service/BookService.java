package Transactions.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Transactions.dao.BookDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @date 2020/11/23 0023-19:52
 */
@Repository
public class BookService {
    @Autowired
    BookDao bookDao;
    @Transactional
    public void checkOut(String username,String isbn){
        bookDao.updateStock(isbn);
        bookDao.updateBalance(username,bookDao.getPrice(isbn));
    }
}
