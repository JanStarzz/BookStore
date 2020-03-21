package com.study.util;

import com.study.bean.User;
import com.study.service.BookService;
import com.study.service.impl.BookServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
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

}