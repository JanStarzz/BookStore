package com.study.servlet;

import com.study.bean.Book;
import com.study.bean.Page;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import com.study.util.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BookManagerServlet",urlPatterns = "/BookManagerServlet")
public class BookManagerServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pn = request.getParameter("pn");
        Page<Book> page = bookService.getPage(pn,"4");
        page.setUrl("BookManagerServlet?method=page");
        request.setAttribute("page",page);
        request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request,response);

    }

    /**
     * 显示所有图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */



    /**
     * 添加图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.paramBean(request,new Book());
        bookService.add(book);
        response.sendRedirect(request.getContextPath()+"/BookManagerServlet?method=page");
    }

    /**
     * 删除图书
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.paramBean(request,new Book());
        String pn = request.getParameter("pn");
        bookService.delete(book);
        response.sendRedirect(request.getContextPath()+"/BookManagerServlet?method=page&pn="+pn);

    }

    /**
     * 修改图书信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pn = request.getParameter("pn");
        Book book = WebUtils.paramBean(request,new Book());
        bookService.update(book);
        response.sendRedirect(request.getContextPath()+"/BookManagerServlet?method=page&pn="+pn);

    }

    /**
     * 获得图书的具体信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void getBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Book book = WebUtils.paramBean(request,new Book());
        Book one = bookService.getOne(book);

        System.out.println(one);

        request.setAttribute("book",one);
        request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request,response);
    }
}
