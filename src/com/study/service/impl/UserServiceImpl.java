package com.study.service.impl;

import com.study.bean.User;
import com.study.dao.UserDao;
import com.study.dao.impl.UserDaoImpl;
import com.study.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User login(User user) {
        return userDao.getUserByUsernameAndPassword(user);
    }

    @Override
    public boolean register(User user) {

        return userDao.registerUser(user);
    }
}
