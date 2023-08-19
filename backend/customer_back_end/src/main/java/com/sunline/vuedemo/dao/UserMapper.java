package com.sunline.vuedemo.dao;

import com.sunline.vuedemo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    User findUserLogin(String userName, String passWord);

    int createUser(User user);
}
