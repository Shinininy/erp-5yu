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
    public class Plant implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "plant_id", type = IdType.AUTO)
      private Integer plantId;

    private String storageLocation;


}
