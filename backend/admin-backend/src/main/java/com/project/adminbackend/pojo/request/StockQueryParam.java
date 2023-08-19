package com.project.adminbackend.pojo.request;

import lombok.Data;

/**
 * 封装了  /operates/stock/query 这个接口的请求参数对象
 */
@Data
public class StockQueryParam {
    private Integer materialId;

    private Integer plantId;

    private String storageLocation;
}
