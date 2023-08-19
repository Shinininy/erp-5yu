package com.example.sdorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Details)表实体类
 */
@Data
@ApiModel("Details")
@TableName("details")
public class Details {

  @ApiModelProperty("主键：细则id")
  @TableId(type= IdType.AUTO)
  private long detailId;

  @ApiModelProperty("数量")
  private long quantity;

  @ApiModelProperty("期望折扣")
  private long expectedProbability;

  @ApiModelProperty("订单总值")
  private double netValue;

  @ApiModelProperty("询价单id")
  private long inquiryId;

  @ApiModelProperty("报价单id")
  private long quotationId;

  @ApiModelProperty("订单id")
  private long orderId;


  @ApiModelProperty("物料id")
  private long materialId;

  @ApiModelProperty("创建批次")
  private long batch;

}
