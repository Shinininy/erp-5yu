package com.example.sdorder.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * (Material)表实体类
 */
@Data
@ApiModel("Material")
@TableName("material")
public class Material {

  @ApiModelProperty("主键：物料id")
  @TableId(type= IdType.AUTO)
  private long materialId;

  @ApiModelProperty("名字")
  private String name;

  @ApiModelProperty("价格")
  private double price;

  @ApiModelProperty("净重")
  private double netWeight;

  @ApiModelProperty("总重")
  private double grossWeight;


}
