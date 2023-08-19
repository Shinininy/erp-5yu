package com.sunline.vuedemo.dto;

import lombok.Data;

@Data
public class UserRegisterReq {
    private String userName;
    private String passWord;
    private String nikeName;
}
