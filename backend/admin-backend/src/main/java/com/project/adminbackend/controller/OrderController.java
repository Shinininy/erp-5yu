package com.project.adminbackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.adminbackend.common.Result;
import com.project.adminbackend.pojo.SalesOrder;
import com.project.adminbackend.service.IOrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private IOrderService orderService;

    @GetMapping("/page")   //订单列表分页查询（仅返回尚未创建发货单的订单）
    public Result findPage( @RequestParam(defaultValue="") Integer orderId,
                            @RequestParam(defaultValue="") Integer shipToParty,
                            @RequestParam String start,
                            @RequestParam String end,
                            @RequestParam Integer pageNum,
                            @RequestParam Integer pageSize){
        Page<SalesOrder> page = orderService.findPage(new Page<>(pageNum, pageSize), orderId, shipToParty, start, end);
        return Result.success(page);
    }

}
