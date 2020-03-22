package com.study.dao;

import com.study.bean.OrderItem;

import java.util.List;

/**
 * 操作订单项的Dao
 * @author Jan
 * @Date 2020/3/22 21:35
 */
public interface OrderItemDao {
    /**
     * 获取某个订单的所有订单项
     * @param orderId
     * @return
     */
    public List<OrderItem> getOrderItems(String orderId);

    /**
     * 保存某个订单项
     * @param item
     * @return
     */
    public int saveOrderItem(OrderItem item);
}
