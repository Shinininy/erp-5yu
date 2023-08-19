package com.project.adminbackend.pojo.request;

import lombok.Data;

/**
 * 封装了  /operates/customer/query 这个接口的请求参数对象
 */

@Data
public class CustomerQueryParam {
    private String country;

    private String city;

    private String name;
}
