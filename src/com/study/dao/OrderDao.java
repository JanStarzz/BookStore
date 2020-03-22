package com.study.dao;

import com.study.bean.Order;

import java.util.List;

/**
 * @author Jan
 * @Date
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    public int updateStatus(Order order);

    /**
     * 获取所有订单（管理员）用
     * @return
     */
    public List<Order> getOrderList();

    /**
     * 获取用户的所有订单
     * @return
     */
    public List<Order> getOrderByUserId(Integer userId);
}
