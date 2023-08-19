package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.pojo.Delivery;
import com.project.adminbackend.dao.DeliveryMapper;
import com.project.adminbackend.service.IDeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;

@Service
public class DeliveryServiceImpl extends ServiceImpl<DeliveryMapper, Delivery> implements IDeliveryService {
    @Resource
    private DeliveryMapper deliveryMapper;

    @Override
    public void createDelivery(Integer orderId, Date date) {
        //创建发货单
        deliveryMapper.createDelivery(orderId, date);
        //创建发货单下的货品条目
        deliveryMapper.createDeliveryItem(orderId);
    }

    @Override
    public void pickComplete(Integer deliveryId, Date date) {
        deliveryMapper.pickComplete(deliveryId, date);
    }

    @Override
    public void postGI(Integer deliveryId, Date plannedGiDate) {
        //更新发货单发货相关信息
        deliveryMapper.DeliveryGI(deliveryId, plannedGiDate);
        //库存变更
        deliveryMapper.StockGI(deliveryId);
    }


    @Override
    public void deleteDelivery(Integer deliveryId) {
        //库存变更
        deliveryMapper.deleteUpdateStock(deliveryId);
        //删除发货单下的货品条目
        deliveryMapper.deleteDeliveryItem(deliveryId);
        //删除发货单
        deliveryMapper.deleteDelivery(deliveryId);
    }


    @Override
    public Page<Delivery> findPage(Page<Delivery> page, Integer orderId, Integer deliveryId, Integer shipToParty,
                                   Boolean giStatus, Boolean pickingStatus){
        return deliveryMapper.findPage(page, orderId, deliveryId, shipToParty,
                giStatus, pickingStatus);
    }

    @Override
    public Delivery findSpecificDelivery(Integer orderId, Integer deliveryId) {
        return deliveryMapper.findSpecificDelivery(orderId, deliveryId);
    }


}
