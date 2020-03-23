package com.study.servlet;

import com.study.bean.Cart;
import com.study.bean.Constants;
import com.study.bean.Order;
import com.study.bean.User;
import com.study.service.OrderService;
import com.study.service.impl.OrderServiceImpl;
import com.study.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author Jan
 * @Date 2020/3/23 12:11
 */
@WebServlet(name = "OrderServlet",urlPatterns = "/OrderServlet")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderServiceImpl();
    /**
     * 结账
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = WebUtils.getLoginUser(request);
        if(user!=null){
            Cart cart = WebUtils.getCart(request);
            String orderId = orderService.checkout(cart,user);
            session.setAttribute("orderId",orderId);
            response.sendRedirect(request.getContextPath()+"/pages/cart/checkout.jsp");
        }else {

            request.setAttribute("msg","此操作需要登录，请先登录");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }

    }

    /**
     * 列出所有订单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = WebUtils.getLoginUser(request);
        List<Order> list = orderService.getMyOrders(user.getId());
        request.setAttribute("orders",list);
        System.out.println(list);
        request.getRequestDispatcher("/pages/order/order.jsp").forward(request,response);
    }

    /**
     * 确认收货
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void received(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String orderId = request.getParameter("orderId");
        orderService.updateStatus(orderId,String.valueOf(Constants.DELIVERED));
        String refer = request.getHeader("referer");
        response.sendRedirect(refer);
    }
}
