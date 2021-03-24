package com.atguigu.junit;

import com.atguigu.pojo.Book;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {

    BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"国哥为什么这么帅","1130",1,10000,
                new BigDecimal("11111"),null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(22,"社会我国哥，人帅话还多","1130",1,10000,
                new BigDecimal("11111"),null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(6));
    }

    @Test
    public void queryBooks() {
        bookService.queryBooks().forEach(System.out::println);
    }
}