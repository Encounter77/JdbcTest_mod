package com.ex.dao;

import com.ex.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component(value = "namedparameterjdbctemplate")
public class OperationImpl_Named implements Operation {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public OperationImpl_Named(DriverManagerDataSource dataSource) {
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Book> queryById(String isbn) {
        return null;
    }


    public List<Book> findAllBooks() {
        return null;
    }


    public void updateBook(String isbn,double price) {
        //占位符全部替换成":name"的形式,填充利用了map.put方法(新占位符=参数),这里仅仅测试该方法
        String sql = "update bookta set price = :price where isbn = :isbn";
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("price",price);
        map.put("isbn",isbn);
        operationResultInfo(checkUpdate(namedParameterJdbcTemplate.update(sql,map)));
    }

    public void deleteBook(String isbn) {

    }

    public void addBook(String isbn,String title,String type,double price) {

    }

    public void showInfo(List<Book> list) {

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
