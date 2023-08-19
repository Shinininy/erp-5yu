package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.pojo.DeliveryItem;
import com.project.adminbackend.dao.DeliveryItemMapper;
import com.project.adminbackend.service.IDeliveryItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeliveryItemServiceImpl extends ServiceImpl<DeliveryItemMapper, DeliveryItem> implements IDeliveryItemService {
    @Resource
    private DeliveryItemMapper deliveryItemMapper;

    @Override
    public List<DeliveryItem> findDeliveryItemList(Integer deliveryId) {
        return deliveryItemMapper.findDeliveryItemList(deliveryId);
    }

    @Override
    public void pickDeliveryItem(Integer deliveryItemId, Integer quantityUpdated, Integer plantIdUpdated,
                                 Integer quantityOriginal, Integer plantIdOriginal) {
        //根据原拣货信息进行库存变更
        deliveryItemMapper.pickStockReverse(deliveryItemId, quantityOriginal, plantIdOriginal);
        //更新货品发货相关信息
        deliveryItemMapper.pickItemUpdate(deliveryItemId, quantityUpdated, plantIdUpdated);
        //根据更新的拣货信息进行库存变更
        deliveryItemMapper.pickStockUpdate(deliveryItemId, quantityUpdated, plantIdUpdated);
    }

}
