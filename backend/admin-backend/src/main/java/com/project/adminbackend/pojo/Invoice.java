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
    public class Invoice implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "invoice_id", type = IdType.AUTO)
      private Integer invoiceId;

    private String customerName;

    private String billingDate;

    private Integer shipToParty;

    private Integer soldToParty;

    private Double netValue;

    private String currency;

    private Integer orderId;


}
