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
@TableName("bprelationship")
public class BprelationshipEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer relationshipId;
	/**
	 * 
	 */
	private String relationshipAtegory;
	/**
	 * 
	 */
	private String searchTerm;
	/**
	 * 
	 */
	private String businessPartner1;
	/**
	 * 
	 */
	private String businessPartner2;
	/**
	 * 
	 */
	private String validFrom;
	/**
	 * 
	 */
	private String validTo;
	/**
	 * 
	 */
	private String vip;
	/**
	 * 
	 */
	private String department;
	/**
	 * 
	 */
	private String functions;

}
