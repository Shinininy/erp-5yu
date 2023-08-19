package com.sunline.vuedemo.controller;

import com.sunline.vuedemo.bean.User;
import com.sunline.vuedemo.dto.LoginReq;
import com.sunline.vuedemo.dto.UserRegisterReq;
import com.sunline.vuedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public int Login(@RequestBody LoginReq req) {
        User user = userService.findUser(req.getUserName(), req.getPassWord());
        if (user == null) {
            return 0;
        }
        return 1;
    }

    @PostMapping("/register")
    public int register(@RequestBody UserRegisterReq req) {
        User userInfo = new User();
        userInfo.setUserName(req.getUserName());
        userInfo.setPassWord(req.getPassWord());
        return userService.insertUser(userInfo);
    }
}
