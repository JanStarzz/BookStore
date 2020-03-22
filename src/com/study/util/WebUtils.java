package com.study.util;

import com.study.bean.Cart;
import com.study.bean.User;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * web相关的工具
 */
public class WebUtils {
    public static<T> T paramBean(HttpServletRequest request,T t){
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field:fields){
            String name = field.getName();
            String value = request.getParameter(name);
            try {
                BeanUtils.setProperty(t,name,value);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T paramBean2(HttpServletRequest request, T t){
        Map map = request.getParameterMap();
            try {
            BeanUtils.populate(t,map);
        }catch (Exception e){
            e.printStackTrace();
        }
        return t;
    }
    public static Cart getCart(HttpServletRequest request) {
        // TODO Auto-generated method stub
        // Cart cart = new Cart();
        // 购物车的整个内容 Cart 在session中保存。
        // 获取购物车
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            // 给session中放入购物车
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public static User getLoginUser(HttpServletRequest request) {
        // TODO Auto-generated method stub
        //1、验证用户是否登陆
        HttpSession session = request.getSession();
        //取出session中的用户
        return  (User) session.getAttribute("user");
    }
}