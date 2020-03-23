package com.study.dao.impl;

import com.study.bean.Order;
import com.study.dao.BaseDao;
import com.study.dao.OrderDao;

import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/22 21:41
 */
public class OrderDaoImpl extends BaseDao<Order> implements OrderDao {
    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into bs_order(order_id,create_date,total_money,status,user_id)" +
                " values(?,?,?,?,?)";
        update(sql,order.getOrderId(),order.getCreateDate(),order.getTotalMoney(),order.getStatus(),order.getUserId());

        return update(sql,order.getOrderId(),order.getCreateDate(),order.getTotalMoney(),order.getStatus(),order.getUserId());

    }

    /**
     * 修改订单状态
     *
     * @param order
     * @return
     */
    @Override
    public int updateStatus(Order order) {
        String sql = "update bs_order set status=? where order_id=?";
        return update(sql,order.getStatus(),order.getOrderId());
    }

    /**
     * 获取所有订单（管理员）用
     *
     * @return
     */
    @Override
    public List<Order> getOrderList() {
        String sql = "select order_id orderId,create_date createDate," +
                "total_money totalMoney,status status,user_id userId from bs_order";
        return getBeanList(sql);
    }

    /**
     * 获取用户的所有订单
     *
     * @return
     */
    @Override
    public List<Order> getOrderByUserId(Integer userId) {
        String sql = "select order_id orderId,create_date createDate," +
                "total_money totalMoney,status status,user_id userId from bs_order where user_id = ?";
        return getBeanList(sql,userId);
    }
}
