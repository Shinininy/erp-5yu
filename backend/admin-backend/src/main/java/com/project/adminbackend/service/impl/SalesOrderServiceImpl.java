package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.pojo.SalesOrder;
import com.project.adminbackend.dao.SalesOrderMapper;
import com.project.adminbackend.service.IOrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SalesOrderServiceImpl extends ServiceImpl<SalesOrderMapper, SalesOrder> implements IOrderService {
    @Resource
    private SalesOrderMapper questionMapper;

    @Override
    public Page<SalesOrder> findPage(Page<SalesOrder> page, Integer orderId, Integer shipToParty, String start, String end) {
        return questionMapper.findPage(page, orderId, shipToParty, start, end);

    }
}
