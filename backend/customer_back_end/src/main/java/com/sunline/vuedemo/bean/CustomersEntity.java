package com.sunline.vuedemo.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Zero
 * @email Zero@gmail.com
 * @date 2023-07-14 21:54:53
 */
@Data
@TableName("customers")
public class CustomersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer customerId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String postalCode;
	/**
	 * 
	 */
	private String city;
	/**
	 * 
	 */
	private String country;
	/**
	 * 
	 */
	private String language;
	/**
	 * 
	 */
	private Integer reconciliationAcct;
	/**
	 * 
	 */
	private Integer sortKey;
	/**
	 * 
	 */
	private Integer paymentTerms;
	/**
	 * 
	 */
	private String salesOrg;
	private String salesDistrict;
	private String customerStatsGroup;
	private String distrChannel;
	/**
	 * 
	 */
	private String division;
	/**
	 * 
	 */
	private String currency;
	/**
	 * 
	 */
	private String priceGroup;
	/**
	 * 
	 */
	private String deliveryPriority;
	/**
	 * 
	 */
	private String shippingConditions;
	/**
	 * 
	 */
	private String deliveringPlant;
	/**
	 * 
	 */
	private String maxPartDeliviries;
	/**
	 * 
	 */
	private String incoterms;
	/**
	 * 
	 */
	private String incotermsLoctaion;
	/**
	 * 
	 */
	private String acctAssmtGrpCust;
	/**
	 * 
	 */
	private String taxClassific;
	private long bpId;
}
