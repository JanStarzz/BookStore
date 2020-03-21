package com.study.dao;

import com.study.bean.Book;

import java.util.List;

public interface BookDao {
    /**
     * 获取所有图书
     * @return
     */
    List<Book> getAllBook();

    /**
     * 添加图书
     * @param book
     * @return
     */
    boolean addBook(Book book);

    /**
     * 删除图书
     * @param book 要删除的图书
     * @return
     */
    boolean delBook(Book book);

    /**
     * 修改图书
     * @param book 要修改的图书，修改后的图书
     * @return
     */
    boolean updateBook(Book book);

    /**
     * 查找一本图书
     * @param book
     * @return
     */
    Book getBook(Book book);

    /**
     * 查找分页列表
     * @param index
     * @param size
     * @return
     */
    List<Book> getPageList(int index,int size);

    /**
     * 查找总记录数
     * @return
     */
    int getTotalCount();

    /**
     * 按价格区间查找
     */
    int getCountByPrice(double min, double max);
    /**
     * 带条件查找
     */

    List<Book> getPageByPrice(int index,int size, double min, double max);
}
