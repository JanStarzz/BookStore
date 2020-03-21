package com.study.test;

import com.study.bean.User;
import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void test(){
        UserDao ud = new UserDaoImpl();
        User user = ud.getUserByUsernameAndPassword(new User(null,"tomcat","password",null));
        System.out.println(user);
    }

    @Test
    public void test2(){
        UserDao ud = new UserDaoImpl();
        boolean b = ud.registerUser(new User(null,"tomcat2","password",null));
        System.out.println(b);
    }
}
