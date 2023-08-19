package com.project.adminbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

@Data
public class Delivery {
    @TableId(value="delivery_id", type= IdType.AUTO)
    private Integer deliveryId;
    private Integer shipToParty;
    private Integer priority;
    private Integer pickingStatus;
    private Double netWeight;
    private Double grossWeight;
    private Date deliveryDate;
    private Date plannedGiDate;
    private Date pickingDate;
    private Integer giStatus;
    private Integer orderId;
}
