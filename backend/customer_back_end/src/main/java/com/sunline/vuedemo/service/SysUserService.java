package com.sunline.vuedemo.service;



import com.sunline.vuedemo.bean.SysUser;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-12-22 14:46:18
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    SysUser queryById(String userId);

    /**
     * 查询多条数据
     *
     *
     * @return 对象列表
     */
    List<SysUser> queryAll(int  currentPage);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(String userId);

}