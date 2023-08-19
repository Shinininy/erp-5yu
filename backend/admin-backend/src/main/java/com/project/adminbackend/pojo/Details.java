package com.project.adminbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author w
 * @since 2023-07-13
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Details implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "detail_id", type = IdType.AUTO)
      private Integer detailId;

    private Integer quantity;

    private Integer expectedProbability;

    private Double netValue;

    private Integer inquiryId;

    private Integer quotationId;

    private Integer orderId;

    private Integer discountId;

    private Integer materialId;


}
