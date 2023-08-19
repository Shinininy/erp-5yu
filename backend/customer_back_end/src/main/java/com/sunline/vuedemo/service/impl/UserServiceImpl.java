package com.sunline.vuedemo.service.impl;

import com.sunline.vuedemo.bean.User;
import com.sunline.vuedemo.dao.UserMapper;
import com.sunline.vuedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User findUser(String userName, String passWord) {
        return userMapper.findUserLogin(userName, passWord);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.createUser(user);
    }
}
