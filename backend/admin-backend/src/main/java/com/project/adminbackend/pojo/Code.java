package com.project.adminbackend.pojo;

public enum Code {

    // 操作成功
    OK(200),

    // 服务器遇到错误
    INTERNAL_ERROR(500),

    // 内容错误
    BAD_REQUEST(400);


    private final Integer code;

    Code(Integer code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
