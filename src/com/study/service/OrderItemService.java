package com.study.service;

import com.study.bean.OrderItem;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/23 0:36
 */
public interface OrderItemService {
    /**
     * 保存订单项
     * @param orderItem
     */
    public void saveItem(List<OrderItem> orderItem);

    /**
     * 获取订单的所有订单项
     * @param orderId
     * @return
     */
    public List<OrderItem> getOrderItems(String orderId);
}
