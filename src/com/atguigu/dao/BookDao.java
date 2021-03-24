package com.atguigu.dao;

import com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {

    /**
     * 添加图书
     *
     * @param book
     * @return
     */
    public int saveBook(Book book);

    /**
     * 删除图书
     *
     * @param id
     * @return
     */
    public int deleteBookById(Integer id);

    /**
     * 修改图书
     *
     * @param book
     * @return
     */
    public int updateBook(Book book);

    /**
     * 根据id查询图书
     */
    public Book queryBookById(Integer id);

    /**
     * 查询全部的图书
     *
     * @return
     */
    public List<Book> queryBooks();

}
