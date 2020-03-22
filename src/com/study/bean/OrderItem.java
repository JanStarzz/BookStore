package com.study.bean;

/**
 * @author 17672
 */
public class OrderItem {
    /**
     * 图书的书名
     */
    private String title;
    /**
     * 购买的数量
     */
    private int count;
    /**
     * 图书的单价
     */
    private double price;
    /**
     * 图书的总价
     */
    private double totalPrice;
    /**
     * 所属
     */
    private String orderId;

    @Override
    public String toString() {
        return "OrderItem{" +
                "title='" + title + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", totalPrice=" + totalPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderItem() {
    }

    public OrderItem(String title, int count, double price, double totalPrice, String orderId) {
        this.title = title;
        this.count = count;
        this.price = price;
        this.totalPrice = totalPrice;
        this.orderId = orderId;
    }
}
