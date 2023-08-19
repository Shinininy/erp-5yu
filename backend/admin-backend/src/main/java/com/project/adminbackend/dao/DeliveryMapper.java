package com.project.adminbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.adminbackend.pojo.Delivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
@Mapper
public interface DeliveryMapper extends BaseMapper<Delivery> {

    void createDelivery(Integer orderId, Date date);
    void createDeliveryItem(Integer orderId);

    void pickComplete(Integer deliveryId, Date date);

    void DeliveryGI(Integer deliveryId, Date plannedGiDate);

    void StockGI(Integer deliveryId);

    void deleteUpdateStock(Integer deliveryId);

    void deleteDelivery(Integer deliveryId);
    void deleteDeliveryItem(Integer deliveryId);

    Page<Delivery> findPage(Page<Delivery> page,
                            @Param("orderId") Integer orderId,
                            @Param("deliveryId") Integer deliveryId,
                            @Param("shipToParty") Integer shipToParty,
                            @Param("giStatus") Boolean giStatus,
                            @Param("pickingStatus") Boolean pickingStatus);

    Delivery findSpecificDelivery(Integer orderId, Integer deliveryId);
}
