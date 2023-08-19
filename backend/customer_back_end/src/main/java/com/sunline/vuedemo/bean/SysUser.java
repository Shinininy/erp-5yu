package com.sunline.vuedemo.bean;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-12-22 11:19:42
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
    /**
     * 用户ID
     */
    private String userId;

    private String tenantId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 登录用户名
     */
    private String userCode;
    /**
     * 密码
     */
    private String password;
    /**
     * 机构ID
     */
    private String orgId;

    private String mobile;
    /**
     * [CC_USER_TYPE]
     * 用户类型
     * 1-员工
     */
    private String userTypeCode;
    /**
     * [CC_USER_STATUS]
     */
    private String userStatusCode;
    /**
     * 记录创建者
     */
    private String createdBy;
    /**
     * 记录创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdTime;
    /**
     * 记录最后更新者
     */
    private String updatedBy;
    /**
     * 记录最后更新时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedTime;
    /**
     * 记录更新次数
     */
    private Double modiNum;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date lockTime;

    private Double passwordRetries;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date passwordUpdateTime;
    /**
     * 皮肤，默认空，蓝色填blue
     */
    private String userSkin;


}