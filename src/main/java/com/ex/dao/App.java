package com.ex.dao;

import com.ex.pojo.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Operation operation = (Operation) context.getBean("jdbctemplate");
        //查询给定isbn号为002所对应的图书信息
        //operation.showInfo(operation.queryById("002"));
        //插入新的图书信息
        //operation.addBook("114","数据结构","教材",68);
        //删除isbn号为114的图书信息
        //operation.deleteBook("114");
        //更新isbn号为120的图书价格为1000
        //operation.updateBook("120",1000);
        //显示所有图书信息
        operation.showInfo(operation.findAllBooks());

    }
}
