package com.study.service;

import com.study.bean.Cart;
import com.study.bean.Order;
import com.study.bean.OrderItem;
import com.study.bean.User;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/23 0:25
 */
public interface OrderService {
    /**
     * 结账
     * @param cart
     * @param user
     * @return
     */
    public String checkout(Cart cart, User user);

    /**
     * 修改订单状态
     * @param orderId
     * @param status
     */
    public void updateStatus(String orderId,String status);

    /**
     * 管理员使用
     * @return
     */
    public List<Order> getAllOrder();

    /**
     * 获取某个用户的订单
     *
     * @param user_id
     * @return
     */
    public List<Order> getMyOrders(Integer user_id);

}
