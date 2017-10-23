package com.ex.dao;

import com.ex.pojo.Book;

import java.util.List;

public interface Operation {
    public List<Book> queryById(String isbn);
    public List<Book> findAllBooks();
    public void updateBook(String isbn,double price);
    public void deleteBook(String isbn);
    public void addBook(String isbn,String title,String type,double price);
    public void showInfo(List<Book> list);
    public boolean checkUpdate(int result);
    public void operationResultInfo(boolean flag);
}
