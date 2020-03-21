package com.study.dao;
import com.study.bean.User;

public interface UserDao {
    /**
     * 按照用户名密码查询详细信息
     * @param user
     * @return
     */
    User getUserByUsernameAndPassword(User user);

    /**
     * 注册，保存用户
     * @param user
     * @return
     */
    boolean registerUser(User user);

}
