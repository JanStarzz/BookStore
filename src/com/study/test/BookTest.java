package com.study.test;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.dao.BaseDao;
import com.study.dao.BookDao;
import com.study.dao.impl.BookDaoImpl;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import org.junit.Test;

public class BookTest {
    BookDao bookDao = new BookDaoImpl();

    @Test
    public void TestBook() {
        Book book = new Book(null, "java入门", "我", 10, 200, 20, null);

        System.out.println(bookDao.addBook(book));
    }

    @Test
    public void TestBook2() {
        Book book = new Book();
        book.setId(2);
        System.out.println(bookDao.delBook(book));
    }

    @Test
    public void TestBook3() {
        Book book = new Book(3, "java入门", "你", 10, 200, 20, null);
        System.out.println(bookDao.getPageList(1,2));
    }
    @Test
    public void Test4(){
        double i = 1.2;
        System.out.println(17/4);
        System.out.println(Math.floor(i));
        System.out.println(Math.ceil(i));
    }

    @Test
    public void Test5(){
        BookService bookService = new BookServiceImpl();
        Page<Book> bookPage = bookService.getPageByPrice("1","4","0","50");
        System.out.println(bookPage);
    }
}
