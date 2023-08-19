package com.project.adminbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.adminbackend.pojo.DeliveryItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DeliveryItemMapper extends BaseMapper<DeliveryItem> {

    List<DeliveryItem> findDeliveryItemList(Integer deliveryId);

    void pickStockReverse(Integer deliveryItemId, Integer quantityOriginal, Integer plantIdOriginal);

    void pickItemUpdate(Integer deliveryItemId, Integer quantityUpdated, Integer plantIdUpdated);

    void pickStockUpdate(Integer deliveryItemId, Integer quantityUpdated, Integer plantIdUpdated);
}
