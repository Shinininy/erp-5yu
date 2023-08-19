package com.example.sdorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (DiscountRules)表实体类
 */
@Data
@ApiModel("DiscountRules")
@TableName("discount_rules")
public class DiscountRules {

  @ApiModelProperty("主键：折扣规则id")
  @TableId(type= IdType.AUTO)
  private long discountId;

  @ApiModelProperty("折扣类型")
  private String discountType;

  @ApiModelProperty("折扣金额/百分比")
  private double num;

  @ApiModelProperty("物料细则id")
  private long detailId;

  @ApiModelProperty("总折扣钱数")
  private double discountAll;
}
