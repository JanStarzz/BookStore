package com.study.service;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.dao.BaseDao;

import java.util.List;

public interface BookService {
    boolean add(Book book);
    boolean update(Book book);
    boolean delete(Book book);
    Book getOne(Book book);
    List<Book> getList();
    Page<Book> getPage(String pageNo, String pageSize);
    Page<Book> getPageByPrice(String pageNo, String pageSize, String minPrice, String maxPrice);
}
