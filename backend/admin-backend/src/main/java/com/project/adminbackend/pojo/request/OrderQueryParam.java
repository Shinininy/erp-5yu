package com.project.adminbackend.pojo.request;

import lombok.Data;

/**
 * 封装了  /operates/salesOrder/condition 这个接口的请求参数对象
 */

@Data
public class OrderQueryParam {
    private Integer soldToParty;

    private String  salesOrganization;

    private String distributionChannel;
}
