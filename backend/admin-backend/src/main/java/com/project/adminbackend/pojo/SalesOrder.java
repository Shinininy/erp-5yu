package com.project.adminbackend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

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
    public class SalesOrder implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "order_id", type = IdType.AUTO)
      private Integer orderId;

    private Integer shipToParty;

    private Integer soldToParty;

    private LocalDate validFrom;

    private LocalDate validTo;

    private LocalDate reqDelivDate;

    private Double netValue;

    private String currency;

    private Integer quotationId;

    private Integer invoiceId;

    private Integer receiptId;


}
