package com.project.adminbackend.controller;

import com.project.adminbackend.common.Result;
import com.project.adminbackend.service.IDeliveryItemService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/deliveryitem")
public class DeliveryItemController {
    @Resource
    private IDeliveryItemService deliveryItemService;


    @GetMapping("/pickitem")    //对发货单中的单个货品拣货
    public Result pickDeliveryItem(@RequestParam Integer deliveryItemId,
                                   @RequestParam Integer quantityUpdated,
                                   @RequestParam Integer plantIdUpdated,
                                   @RequestParam(defaultValue="0")  Integer quantityOriginal,
                                   @RequestParam(defaultValue="1")  Integer plantIdOriginal){
        deliveryItemService.pickDeliveryItem(deliveryItemId, quantityUpdated,
                plantIdUpdated, quantityOriginal, plantIdOriginal);
        return Result.success();
    }

    @GetMapping("/list")    //发货单货品列表
    public Result findDeliveryItemList(@RequestParam Integer deliveryId){
        return Result.success(deliveryItemService.findDeliveryItemList(deliveryId));
    }

}
