package com.study.dao.impl;

import com.study.bean.User;
import com.study.dao.BaseDao;
import com.study.dao.UserDao;

public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User getUserByUsernameAndPassword(User user) {
        String sql = "select * from bs_user where username = ? and password = ?";
        user = this.getBean(sql,user.getUsername(),user.getPassword());
        return user;
    }

    @Override
    public boolean registerUser(User user) {
        String sql = "insert into bs_user(username,password,email) values(?,?,?)";
        int i = this.update(sql,user.getUsername(),user.getPassword(),user.getEmail());
        return i>0;
    }
}
