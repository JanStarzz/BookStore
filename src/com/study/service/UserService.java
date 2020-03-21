package com.study.service;

import com.study.bean.User;

public interface UserService {
    public User login(User user);
    public boolean register(User user);
}
