package com.study.test;

import com.study.bean.Book;
import com.study.bean.Cart;
import org.junit.Test;

public class CartTest {
    Book book = new Book(1,"西游记1","",12.2,100, 100, "");
    Book book2 = new Book(2,"西游记2","",13.2,100, 100, "");
    Book book3 = new Book(3,"西游记3","",14.2,100, 100, "");

    @Test
    public void test2(){
        Cart cart = new Cart();
        cart.addBook2Cart(book);
        cart.addBook2Cart(book2);

        cart.addBook2Cart(book3);
        System.out.println("书本："+cart.getTotalCount());
        System.out.println("当前总价："+cart.getTotalMoney());
        System.out.println("项目："+cart.getAllItems());
        System.out.println("修改之后---");
//        cart.deleteItem(book.getId().toString());
//        System.out.println("书本："+cart.getTotalCount());
//        System.out.println("当前总价："+cart.getTotalMoney());
//        System.out.println("项目："+cart.getAllItems());
        cart.updateCount(book.getId().toString(),3);
        System.out.println("书本："+cart.getTotalCount());
        System.out.println("当前总价："+cart.getTotalMoney());
        System.out.println("项目："+cart.getAllItems());
    }
}
