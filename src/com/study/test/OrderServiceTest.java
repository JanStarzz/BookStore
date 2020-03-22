package com.study.test;

import com.study.bean.Book;
import com.study.bean.Cart;
import com.study.bean.Order;
import com.study.bean.User;
import com.study.service.BookService;
import com.study.service.OrderService;
import com.study.service.impl.BookServiceImpl;
import com.study.service.impl.OrderServiceImpl;
import org.junit.Test;

/**
 * @author Jan
 * @Date 2020/3/23 1:15
 */
public class OrderServiceTest {
    BookService bookService = new BookServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void test1(){
        Book book = new Book();
        book.setId(3);
        User user = new User();
        user.setId(1);
        Book one = bookService.getOne(book);
        Cart cart = new Cart();
        cart.addBook2Cart(one);
        cart.addBook2Cart(one);
        String id =  orderService.checkout(cart,user);
        System.out.println(id);
    }
}
