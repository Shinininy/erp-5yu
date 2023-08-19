package com.sunline.vuedemo.dao;


import com.sunline.vuedemo.bean.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-22 11:19:44
 */

//@Mapper : 表示本类是一个 MyBatis 的 Mapper
@Mapper
@Repository
public interface SysUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUser queryById(String userId);



    /**
     * 通过实体作为筛选条件查询
     *
     *
     * @return 对象列表
     */
    List<SysUser> queryAll(int currentPage);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 影响行数
     */
    int update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(String userId);

}