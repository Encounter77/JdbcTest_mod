package com.ex.dao;

import com.ex.pojo.Book;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RowMapperImpl implements RowMapper<Book> {

    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
        Book book = new Book();
        book.setIsbn(resultSet.getString("isbn"));
        book.setTitle(resultSet.getString("title"));
        book.setType(resultSet.getString("type"));
        book.setPrice(resultSet.getDouble("price"));
        return book;
    }
}
