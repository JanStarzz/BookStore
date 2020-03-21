package com.study.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 购物车，保存每个购物项的信息，还封装了对购物车操作的方法
 */
public class Cart implements Serializable {
    /**
     * 保存所有的购物项
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<>();

    /**
     * 添加到购物车
     */
    public void addBook2Cart(Book book){
        CartItem item = items.get(book.getId());
        if (item == null){
            CartItem cartItem = new CartItem();
            cartItem.setBook(book);
            cartItem.setCount(1);
            items.put(book.getId(),cartItem);
        }
        else {
            item.setCount(item.getCount()+1);
        }
    }

    /**
     * 从购物车中删除某一项
     */
    public void deleteItem(String bookId){
        int id = Integer.parseInt(bookId);
        items.remove(id);
    }

    /**
     * 修改数量
     * @param bookId
     * @param count
     */
    public void updateCount(String bookId, int count){
        int id = Integer.parseInt(bookId);
        CartItem cartItem = items.get(id);
        cartItem.setCount(count);
    }

    /**
     *清空购物车
     */
    public void clear(){
        items.clear();
    }
    /**
     * 返回所有的购物项
     * @return
     */
    public List<CartItem> getAllItems(){
        return new ArrayList<>(items.values());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "items=" + items +
                '}';
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    /**
     * 获取商品总数
     * @return
     */
    public int getTotalCount() {
        List<CartItem> list = getAllItems();
        int count = 0;
        for (CartItem cartItem: list) {
            count += cartItem.getCount();
        }
        return count;
    }


    /**
     * 获取总金额
     * @return
     */
    public double getTotalMoney() {
        List<CartItem> list = getAllItems();
        BigDecimal money = new BigDecimal(String.valueOf(0.0));
        for (CartItem cartItem: list
        ) {
            BigDecimal totalPrice = new BigDecimal(String.valueOf(cartItem.getTotalPrice()));
            money = money.add(totalPrice);
        }
        return money.doubleValue();
    }


    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;

    }
}
