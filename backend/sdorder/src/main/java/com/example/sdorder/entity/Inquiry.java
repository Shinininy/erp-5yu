package com.example.sdorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * (Inquiry)表实体类
 */
@Data
@ApiModel("Inquiry")
@TableName("inquiry")
public class Inquiry{

  @ApiModelProperty("主键：询价单id")
  @TableId(type= IdType.AUTO)
  private long inquiryId;

  @ApiModelProperty("收获客户")
  private long shipToParty;

  @ApiModelProperty("订单客户")
  private long soldToParty;

  @ApiModelProperty("起始有效期")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate validFrom;

  @ApiModelProperty("终止有效期")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate validTo;

  @ApiModelProperty("需要运送日期")
  @JsonFormat(pattern = "yyyy-MM-dd")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate reqDelivDate;

  @ApiModelProperty("订单总值")
  private double netValue;

  @ApiModelProperty("期望订单总值")
  private double expectOrdVal;

  @ApiModelProperty("货币种类")
  private String currency;

  @ApiModelProperty("销售组织")
  private long salesOrg;

  @ApiModelProperty("分销渠道")
  private long distrChannel;

  @ApiModelProperty("分销方式")
  private long division;

  @ApiModelProperty("销售方")
  private long salesOffice;

  @ApiModelProperty("销售组")
  private long salesGroup;

  @ApiModelProperty("客户参考")
  private long customerReference;

}
