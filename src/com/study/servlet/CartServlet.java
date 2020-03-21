package com.study.servlet;

import com.study.bean.Book;
import com.study.bean.Cart;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import com.study.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends BaseServlet {
    BookService bs = new BookServiceImpl();
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.paramBean(request,new Book());
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart==null){
            //session放入购物车
            cart = new Cart();
            session.setAttribute("cart",cart);
        }
        Book one = bs.getOne(book);
        cart.addBook2Cart(one);
        session.setAttribute("title",one.getTitle());
        String refer = request.getHeader("referer");
        response.sendRedirect(refer);

    }

}
