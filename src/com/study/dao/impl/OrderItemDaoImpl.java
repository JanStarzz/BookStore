package com.study.dao.impl;

import com.study.bean.Order;
import com.study.bean.OrderItem;
import com.study.dao.BaseDao;
import com.study.dao.OrderItemDao;
import com.study.servlet.BaseServlet;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/22 21:40
 */
public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao{
    @Override
    public List<OrderItem> getOrderItems(String orderId) {
        String sql = "select id, title, count, price, total_price totalPrice," +
                "order_id orderId from bs_order_item where order_id=?";
        return getBeanList(sql,orderId);
    }

    @Override
    public int saveOrderItem(OrderItem item) {
        String sql = "insert into bs_order_item(title,count,price,total_price, " +
                "order_id) values(?,?,?,?,?)";
        return update(sql,item.getTitle(),item.getCount(),item.getPrice(),item.getTotalPrice(),item.getOrderId());
    }

    @Override
    public int saveBatch(List<OrderItem> params){
        String sql = "insert into bs_order_item(title,count,price,total_price, " +
                "order_id) values(?,?,?,?,?)";
        Object[][] objects = new Object[params.size()][5];
        int count = 0;
        for(OrderItem item:params){
            objects[count++] = new Object[]{item.getTitle(),item.getCount()
            ,item.getPrice(),item.getTotalPrice(),item.getOrderId()};
        }
        return batch(sql,objects);
    }
}
