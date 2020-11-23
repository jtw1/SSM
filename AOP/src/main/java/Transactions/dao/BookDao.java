package Transactions.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @date 2020/11/23 0023-19:40
 */
@Repository
public class BookDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 减去某个用户的余额
     * @param userName
     * @param price
     */
    public void updateBalance(String userName,int price){
        String sql="UPDATE account SET balance=balance-? WHERE username=?";
        jdbcTemplate.update(sql,price,userName);
    }

    /**
     * 按照图书的ISBN获取某本书的价格
     * @param isbn
     * @return
     */
    public int getPrice(String isbn){
        String sql="SELECT price FROM book WHERE isbn=?";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);
    }

    /**
     * 减库存
     * @param isbn
     */
    public void updateStock(String isbn){
        String sql="UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
        jdbcTemplate.update(sql,isbn);
    }
}
