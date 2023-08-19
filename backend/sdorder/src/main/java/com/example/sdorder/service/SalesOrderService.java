package com.example.sdorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.SalesOrder;
import com.example.sdorder.entity.dto.OrderDto;
import org.springframework.transaction.annotation.Transactional;


/**
 * (SalesOrder)表服务接口
 */
public interface SalesOrderService {

    /**
     * 通过id查询salesorder
     * @param id
     * @return
     */
    SalesOrder getSalesOrderById(Long id);

    /**
     * 分页查询订单
     * @param page
     * @param order
     * @return
     */
    IPage<SalesOrder> getPageList(Page page, SalesOrder order);

    /**
     * 查找该order所有details与discountrules
     * @param orderId
     * @return
     */
    @Transactional
    OrderDto getAlDiscountrulesAlDetails(Long orderId);

    /**
     * 保存order
     * @param order
     * @param batch
     * @return
     */
    long saveOrder(SalesOrder order,Long batch);

    /**
     * 根据quotation创建order
     * @param quotationId
     * @return
     */
    @Transactional
    long AddOrderByQuotationId(Long quotationId);

    /**
     * 删除order
     * @param orderId
     * @return
     */
    int  deleteOrder(Long orderId);

}
