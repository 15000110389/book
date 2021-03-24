package com.atguigu.service;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookService {

    /**
     * 添加图书
     * @param book
     */
    public void addBook(Book book);
    /**
     * 删除图书
     */
    public void deleteBookById(Integer id);

    /**
     * 更新图书
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 根据id查询图书
     * @param id
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部图书
     * @return
     */
    public List<Book> queryBooks();

}
