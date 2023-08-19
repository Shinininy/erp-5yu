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
    public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "customer_id", type = IdType.AUTO)
      private Integer customerId;

    private String title;

    private String name;

    private Integer postalCode;

    private String city;

    private String country;

    private String language;

    private Integer reconciliationAcct;

    private Integer sortKey;

    private Integer paymentTerms;

    private String salesOrg;

    private String distrChannel;

    private String division;

    private String salesDistrict;

    private String currency;

    private Integer priceGroup;

    private Integer customerStatsGroup;

    private Integer deliveryPriority;

    private Integer shippingConditions;

    private String deliveringPlant;

    private Integer maxPartDeliviries;

    private String incoterms;

    private String incotermsLoctaion;

    private Integer acctAssmtGrpCust;

    private Integer taxClassific;

    private Integer bpId;


}
