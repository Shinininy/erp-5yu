package com.project.adminbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DeliveryItem {
    @TableId(value="delivery_item_id", type= IdType.AUTO)
    private Integer deliveryItemId;
    private Integer pickingStatus;
    private Integer pickingQuantity;
    private Integer originalDeliveryQuantity;
    private Integer plantId;
    private Integer materialId;
    private Integer deliveryId;
    @TableField(exist = false)
    private String name;
}
