package com.study.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 每个购物项
 */
public class CartItem implements Serializable {
    //代表哪本书
    private Book book;
    //书的数量
    private int count;
    //总价格
    private double totalPrice;

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", count=" + count +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public CartItem() {
    }

    public CartItem(Book book, int count, double totalPrice) {
        this.book = book;
        this.count = count;
        this.totalPrice = totalPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 计算总金额
     * @return
     */

    public double getTotalPrice() {
        BigDecimal price = new BigDecimal(String.valueOf(getBook().getPrice()));
        BigDecimal count = new BigDecimal(String.valueOf(getCount()));

        return price.multiply(count).doubleValue();
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
