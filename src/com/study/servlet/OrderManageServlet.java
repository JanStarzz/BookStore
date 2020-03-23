package com.study.servlet;

import com.study.bean.Constants;
import com.study.bean.Order;
import com.study.service.OrderService;
import com.study.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/23 13:21
 */
@WebServlet(name = "OrderManageServlet",urlPatterns = "/OrderManageServlet")
public class OrderManageServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();

    /**
     * 列出所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders = orderService.getAllOrder();
        request.setAttribute("orders",orders);
        request.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(request,response);
    }

    /**
     * 发货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.updateStatus(orderId, String.valueOf(Constants.DELIVERING));
        String refer = request.getHeader("referer");
        System.out.println(refer);
        response.sendRedirect(refer);
    }
}
