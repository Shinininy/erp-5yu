package com.example.sdorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Customer)表实体类
 */
@Data
@ApiModel("Customer")
@TableName("customers")
public class Customer {

  @ApiModelProperty("主键：客户id")
  @TableId(type= IdType.AUTO)
  private long customerId;

  @ApiModelProperty("标签")
  private String title;

  @ApiModelProperty("名字")
  private String name;

  @ApiModelProperty("邮政编码")
  private long postalCode;

  @ApiModelProperty("城市")
  private String city;

  @ApiModelProperty("国家")
  private String country;

  @ApiModelProperty("语言")
  private String language;
  private long reconciliationAcct;
  private long sortKey;
  private long paymentTerms;
  private String salesOrg;
  private String distrChannel;
  private String division;
  private String salesDistrict;
  private String currency;
  private long priceGroup;
  private long customerStatsGroup;
  private long deliveryPriority;
  private long shippingConditions;
  private String deliveringPlant;
  private long maxPartDeliviries;
  private String incoterms;
  private String incotermsLoctaion;
  private long acctAssmtGrpCust;
  private long taxClassific;
  private long bpId;

}
