package com.ex.dao;

import com.ex.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Component(value = "jdbctemplate")
public class OperationImpl implements Operation {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Book> queryById(String isbn) {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from bookta where isbn = ?";
        list = jdbcTemplate.query(sql, new RowMapperImpl(),isbn);
        return list;
    }


    public List<Book> findAllBooks() {
        List<Book> list = new ArrayList<Book>();
        String sql = "select * from bookta";
        list = jdbcTemplate.query(sql, new RowMapperImpl());
        return list;
    }


    public void updateBook(String isbn,double price) {
        String sql = "update bookta set price = ? where isbn = ?";
        operationResultInfo(checkUpdate(jdbcTemplate.update(sql,price,isbn)));
    }

    public void deleteBook(String isbn) {
        String sql = "delete from bookta where isbn = ?";
        operationResultInfo(checkUpdate(jdbcTemplate.update(sql,isbn)));
    }

    public void addBook(String isbn,String title,String type,double price) {
        String sql = "insert into bookta values (?,?,?,?)";
        operationResultInfo(checkUpdate(jdbcTemplate.update(sql,isbn,title,type,price)));
    }

    public void showInfo(List<Book> list) {
        Iterator<Book> iterator = list.iterator();
        while(iterator.hasNext()){
            Book tempBook = iterator.next();
           System.out.println("BookName:"+tempBook.getTitle()
           +" BookIsbn:"+tempBook.getIsbn() +" BookType:"+tempBook.getType() +" BookPrice:"+tempBook.getPrice()
           );
        }
    }

    public boolean checkUpdate(int result) {
        boolean flag = false;
        if (result == 1){
            flag = true;
        }
        return flag;
    }

    public void operationResultInfo(boolean flag) {
        if(flag){
            System.out.println("操作成功");
        }else {
            System.out.println("操作失败");
        }
    }


}
