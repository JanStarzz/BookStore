package com.study.dao.impl;

import com.study.bean.Book;
import com.study.dao.BaseDao;
import com.study.dao.BookDao;

import java.util.List;


/**
 * 操作图书的DAO
 */
public class BookDaoImpl extends BaseDao<Book> implements BookDao{
    @Override
    public List<Book> getAllBook() {
        String sql = "select id, title, author, price, sales, stock, img_path as imgPath from bs_book";
        return getBeanList(sql);
    }

    @Override
    public boolean addBook(Book book) {
        String sql = "insert into bs_book(title, author, price, sales, stock, img_path) values(?,?,?,?,?,?)";
        int i = update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
        return i>0;
    }

    @Override
    public boolean delBook(Book book) {
        String sql = "delete from bs_book where id = ?";
        int i = update(sql,book.getId());
        return i>0;
    }

    @Override
    public boolean updateBook(Book book) {
        String sql = "update bs_book set title=?, author=?, price=?, sales=?, stock=?, img_path=? where id=?";
        int i = update(sql,book.getTitle(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());

        return i>0;
    }

    @Override
    public Book getBook(Book book) {
        String sql = "select id, title, author, price, sales, stock, img_path as imgPath from bs_book where id=?";

        return getBean(sql,book.getId());
    }


    @Override
    public List<Book> getPageList(int index, int size){
        String sql = "select id, title, author, price, sales, stock, img_path as imgPath from bs_book " +
                "limit ?,?";
        return getBeanList(sql,index,size);

    }

    @Override
    public int getTotalCount() {
        String sql = "select count(*) from bs_book";
        Object o = getSingleValue(sql);
        int parserInt = 0;
        try {
            parserInt = Integer.parseInt(o.toString());
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return parserInt;
    }

    /**
     * 根据图书价格查找记录数
     * @param min
     * @param max
     * @return
     */
    @Override
    public int getCountByPrice(double min, double max) {
        String sql = "select count(*) from bs_book where price between ? and ?";
        int i = 0;
        try {
            i = Integer.parseInt(getSingleValue(sql,min,max).toString());

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Book> getPageByPrice(int index, int size, double min, double max) {
        String sql = "select id, title, author, price, sales, stock, img_path as imgPath from bs_book " +
                "where price between ? and ? limit ?,?";
        return getBeanList(sql, min, max, index, size);
    }
}
