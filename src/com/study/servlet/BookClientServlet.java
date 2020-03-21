package com.study.servlet;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookClientServlet",urlPatterns = "/BookClientServlet")
public class BookClientServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();
    /**
     * 给用户展示图书数据，用分页的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pn = request.getParameter("pn");
        Page<Book> page = bookService.getPage(pn,"4");
        page.setUrl("BookClientServlet?method=page");

        request.setAttribute("page",page);

        request.getRequestDispatcher("/pages/book/book_list.jsp").forward(request,response);
    }

    protected void pageByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String max = request.getParameter("max");
        String min = request.getParameter("min");
        String pn = request.getParameter("pn");
        Page<Book> page=bookService.getPageByPrice(pn,"4",min,max);
        page.setUrl("BookClientServlet?method=pageByPrice&max="+max+"&min="+min);
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/book/book_list.jsp").forward(request,response);
    }
}
