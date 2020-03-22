package com.study.servlet;

import com.google.code.kaptcha.Constants;
import com.study.bean.User;
import com.study.service.UserService;
import com.study.service.impl.UserServiceImpl;
import com.study.util.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author 17672
 */
@WebServlet(name = "UserServlet",urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
	/**
	 * 注册新用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */

	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
		UserService us = new UserServiceImpl();
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(!sessionCode.equals(code)){
			request.setAttribute("msg","验证码错误");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
			return;
		}
		User user = WebUtils.paramBean(request,new User());
		Boolean flag =  us.register(user);
		if (flag){
			request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);

		}
	}

	/**
	 * 登录
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService us = new UserServiceImpl();
		User user0  = WebUtils.paramBean(request,new User());
		User user = us.login(user0);
		HttpSession session = request.getSession();
		session.setAttribute("user",user);

		if(user == null){
			request.setAttribute("msg","用户名密码错误");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
}
