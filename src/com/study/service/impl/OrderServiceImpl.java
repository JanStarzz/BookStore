package com.study.service.impl;

import com.study.bean.*;
import com.study.dao.OrderDao;
import com.study.dao.OrderItemDao;
import com.study.dao.impl.OrderDaoImpl;
import com.study.dao.impl.OrderItemDaoImpl;
import com.study.service.BookService;
import com.study.service.OrderItemService;
import com.study.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/23 0:35
 */
public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao itemDao = new OrderItemDaoImpl();
    OrderItemService itemService = new OrderItemServiceImpl();
    BookService bookService = new BookServiceImpl();
    /**
     * 结账
     *
     * @param cart
     * @return
     */
    @Override
    public String checkout(Cart cart, User user) {
        //把购物车里的项目封装并保存
        //1.封装订单对象
        Order order = new Order();

        order.setCreateDate(new Date());
        long millis = System.currentTimeMillis();
        String orderId = millis+""+user.getId();
        order.setOrderId(orderId);
        order.setTotalMoney(cart.getTotalMoney());
        order.setStatus(0);
        order.setUserId(user.getId());
        //2.封装订单项对象
        List<CartItem> list = cart.getAllItems();
        List<OrderItem> orderItem = new ArrayList<>();
        for (CartItem cartItem: list){
            OrderItem item = new OrderItem(cartItem.getBook().getTitle(),cartItem.getCount(),
                    cartItem.getBook().getPrice(),cartItem.getTotalPrice(),orderId);
            orderItem.add(item);
        }
        //3.保存订单
        orderDao.saveOrder(order);
        //4.保存订单项
        itemService.saveItem(orderItem);
        //5.修改相应库存
        for(CartItem item: list){
            Book book = item.getBook();
            int count = item.getCount();
            book.setStock(book.getStock()-count);
            book.setSales(book.getSales()+count);
            bookService.update(book);
        }
        return orderId;
    }

    /**
     * 修改订单状态
     *
     * @param orderId
     * @param status
     */
    @Override
    public void updateStatus(String orderId, String status) {
        Order order =new Order();
        order.setOrderId(orderId);
        int parserInt = Integer.parseInt(status);
        order.setStatus(parserInt);
        orderDao.updateStatus(order);
    }

    /**
     * 管理员使用
     *
     * @return
     */
    @Override
    public List<Order> getAllOrder() {
        return orderDao.getOrderList();
    }

    /**
     * 获取某个用户的订单
     *
     * @param user_id
     * @return
     */
    @Override
    public List<Order> getMyOrders(Integer user_id) {
        return orderDao.getOrderByUserId(user_id);
    }


}
