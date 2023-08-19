package com.sunline.vuedemo.service;

import com.sunline.vuedemo.bean.User;

public interface UserService {
    User findUser(String userName, String passWord);

    int insertUser(User user);
}
