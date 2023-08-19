package com.project.adminbackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.adminbackend.pojo.SalesOrder;


public interface IOrderService extends IService<SalesOrder> {
    Page<SalesOrder> findPage(Page<SalesOrder> page, Integer orderId, Integer shipToParty, String start, String end);
}
