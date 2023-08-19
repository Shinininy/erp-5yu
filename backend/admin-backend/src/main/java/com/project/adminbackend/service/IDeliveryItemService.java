package com.project.adminbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.adminbackend.pojo.DeliveryItem;

import java.util.List;

public interface IDeliveryItemService extends IService<DeliveryItem> {


    List<DeliveryItem> findDeliveryItemList(Integer deliveryId);

    void pickDeliveryItem(Integer deliveryItemId, Integer quantityUpdated,
                          Integer plantIdUpdated, Integer quantityOriginal, Integer plantIdOriginal);
}
