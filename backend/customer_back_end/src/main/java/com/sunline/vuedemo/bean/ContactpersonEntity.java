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
@TableName("contactperson")
public class ContactpersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer contactPersonNumber;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String firstName;
	/**
	 * 
	 */
	private String lastName;
	/**
	 * 
	 */
	private String correspondanceLang;
	/**
	 * 
	 */
	private String country;

}
