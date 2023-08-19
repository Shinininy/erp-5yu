package com.project.adminbackend.pojo.request;

import lombok.Data;

/**
 * 封装了  /operates/invoice/query 这个接口的请求参数对象
 */
@Data
public class InvoiceQueryParam {
    private Integer soldToParty;

    private String billingDate;

    private String salesOrganization;

    private String distributionChannel;
}
