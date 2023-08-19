package com.example.sdorder.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.SalesOrder;
import com.example.sdorder.entity.dto.OrderDto;
import com.example.sdorder.service.SalesOrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private SalesOrderService salesOrderService;

    @ApiOperation("分页查询salesorder")
    @GetMapping("getPageList")
    public R<IPage>  getPageList(Page page, SalesOrder order){
        IPage<SalesOrder> pageList = salesOrderService.getPageList(page, order);
        return R.success(pageList);
    }

    @ApiOperation("通过id查询salesorder")
    @GetMapping("getOrderById")
    public R<SalesOrder> getOrderById(Long id){
        SalesOrder salesOrder = salesOrderService.getSalesOrderById(id);
        return R.success(salesOrder);
    }

    @ApiOperation("查询该order下所有details与其对应discountrules")
    @GetMapping("getAlDiscountrulesAlDetails")
    public R<OrderDto> getAlDiscountrulesAlDetails(Long orderId){
        OrderDto orderDto= salesOrderService.getAlDiscountrulesAlDetails(orderId);
        return R.success(orderDto);
    }

    @ApiOperation("保存order")
    @GetMapping("saveOrder")
    public R<Long>  saveOrder(SalesOrder order,Long batch){
        long saveOrderId = salesOrderService.saveOrder(order,batch);
        return R.success(saveOrderId);
    }

    @ApiOperation("根据qutationid创建salesorder")
    @GetMapping("AddOrderByQuotationId")
    public R<Long>  AddOrderByQuotationId(Long quotationId){
        long orderId = salesOrderService.AddOrderByQuotationId(quotationId);
        return R.success(orderId);
    }

    @ApiOperation("删除order")
    @GetMapping("deleteOrder")
    public R<Integer>  deleteOrder(Long orderId){
        int i = salesOrderService.deleteOrder(orderId);
        return R.success(i);
    }


}
