package com.study.service.impl;

import com.study.bean.OrderItem;
import com.study.dao.OrderItemDao;
import com.study.dao.impl.OrderItemDaoImpl;
import com.study.service.OrderItemService;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/23 0:38
 */
public class OrderItemServiceImpl implements OrderItemService {
    OrderItemDao itemDao = new OrderItemDaoImpl();
    /**
     * 保存订单项
     *
     * @param orderItem
     */
    @Override
    public void saveItem(List<OrderItem> orderItem) {
        for (OrderItem orderItem1:orderItem){
            itemDao.saveOrderItem(orderItem1);
        }
    }

    /**
     * 获取订单的所有订单项
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        return itemDao.getOrderItems(orderId);
    }
}
