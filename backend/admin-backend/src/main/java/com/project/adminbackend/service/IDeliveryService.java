package com.project.adminbackend.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.adminbackend.pojo.Delivery;

import java.sql.Date;

public interface IDeliveryService extends IService<Delivery> {
    void createDelivery(Integer orderId, Date date);

    void pickComplete(Integer deliveryId, Date date);

    void postGI(Integer deliveryId, Date plannedGiDate);

    void deleteDelivery(Integer deliveryId);

    Page<Delivery> findPage(Page<Delivery> page, Integer orderId, Integer deliveryId, Integer shipToParty,
                            Boolean giStatus, Boolean pickingStatus);

    Delivery findSpecificDelivery(Integer orderId, Integer deliveryId);
}
