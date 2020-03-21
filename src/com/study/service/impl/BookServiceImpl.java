package com.study.service.impl;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.dao.BookDao;
import com.study.dao.impl.BookDaoImpl;
import com.study.service.BookService;

import java.util.List;

/**
 * 图书业务逻辑实现
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public boolean add(Book book) {
         return bookDao.addBook(book);
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public boolean delete(Book book) {
        return bookDao.delBook(book);
    }

    @Override
    public Book getOne(Book book) {
        return bookDao.getBook(book);
    }

    @Override
    public List<Book> getList() {
        return bookDao.getAllBook();
    }

    @Override
    public Page<Book> getPage(String pageNo,String pageSize) {
        Page<Book> page = new Page<Book>();
        int pn = 1;
        int ps = page.getPageSize();
       try {
           pn = Integer.parseInt(pageNo);
           pn = pn>0?pn:1;
           ps = Integer.parseInt(pageSize);

       }catch (NumberFormatException e){
           e.printStackTrace();
       }
        page.setPageSize(ps);
        int totalCount = bookDao.getTotalCount();
        page.setTotalCount(totalCount);
        page.setPageNo(pn);



        List<Book> books = bookDao.getPageList(page.getIndex(),page.getPageSize());
        page.setList(books);
        return page;
    }

    @Override
    public Page<Book> getPageByPrice(String pageNo, String pageSize, String minPrice, String maxPrice) {
        Double min = 0.0;
        Double max = Double.MAX_VALUE;
        try {
            min = Double.parseDouble(minPrice);
            max = Double.parseDouble(maxPrice);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        Page<Book> page = new Page<Book>();
        int pn = 1;
        int ps = page.getPageSize();
        try {
            pn = Integer.parseInt(pageNo);
            pn = pn>0?pn:1;
            ps = Integer.parseInt(pageSize);

        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        int count = bookDao.getCountByPrice(min,max);
        page.setTotalCount(count);
        page.setPageSize(ps);
        page.setPageNo(pn);
        List<Book> list =bookDao.getPageByPrice(page.getIndex(),page.getPageSize(),min,max);
        page.setList(list);

        //bookDao.getPageByPrice()

        return page;
    }

}
