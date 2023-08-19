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
    public class Stock implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "stock_id", type = IdType.AUTO)
      private Integer stockId;

    private Integer reservedStock;

    private Integer unrestrictedUseStock;

    private Integer onOrderStock;

    private Integer materialId;

    private Integer plantId;


}
