package com.project.adminbackend.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.adminbackend.common.Result;
import com.project.adminbackend.pojo.Delivery;
import com.project.adminbackend.pojo.SalesOrder;
import com.project.adminbackend.service.IDeliveryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    long time = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(time);

    @Resource
    private IDeliveryService deliveryService;

    @PostMapping("/create")  //创建发货单
    public Result create(@RequestBody SalesOrder order){
        Integer id = order.getOrderId();
        deliveryService.createDelivery(id, date);
        return Result.success();
    }

    @GetMapping("/pickcomplete")    //发货单拣货完成确认
    public Result pickComplete(@RequestParam Integer deliveryId){
        deliveryService.pickComplete(deliveryId, date);
        return Result.success();
    }

    @GetMapping("/postgi")     //发货单发货
    public Result postGI(@RequestParam Integer deliveryId) {
        deliveryService.postGI(deliveryId, date);
        return Result.success();
    }

    @GetMapping("/delete")    //删除发货单
    public Result delete(@RequestParam Integer deliveryId) {
        deliveryService.deleteDelivery(deliveryId);
        return Result.success();
    }

    @GetMapping("/page")      //发货单列表分页查询
    public Result findPage(
            @RequestParam(defaultValue="") Integer orderId,
            @RequestParam(defaultValue="") Integer deliveryId,
            @RequestParam(defaultValue="") Integer shipToParty,
            @RequestParam(defaultValue="") Boolean giStatus,
            @RequestParam(defaultValue="") Boolean pickingStatus,
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize){
        Page<Delivery> page = deliveryService.findPage(new Page<>(pageNum, pageSize), orderId, deliveryId, shipToParty,
                giStatus, pickingStatus);
        return Result.success(page);
    }

    @GetMapping("/specific")
    public Result findSpecific(@RequestParam(defaultValue="") Integer orderId, @RequestParam(defaultValue="") Integer deliveryId){
        return Result.success(deliveryService.findSpecificDelivery(orderId, deliveryId));
    }

}
