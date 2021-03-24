package com.atguigu.junit;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDao bookDao = new BookDaoImpl();

    @Test
    public void saveBook() {
        bookDao.saveBook(new Book(null,"国哥帅的一踏糊涂","崔荣老师",10000,0,
                new BigDecimal("9.9"), null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"暗恋国哥那些","崔荣老师",10000,0,
                new BigDecimal("9.9"), null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(10));
    }

    @Test
    public void queryBooks() {
        bookDao.queryBooks().forEach(System.out::println);
    }
}