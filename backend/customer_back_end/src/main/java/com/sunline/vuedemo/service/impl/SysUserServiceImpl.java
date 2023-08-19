package com.sunline.vuedemo.service.impl;


import com.sunline.vuedemo.bean.SysUser;
import com.sunline.vuedemo.dao.SysUserMapper;
import com.sunline.vuedemo.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-12-22 14:46:18
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(String userId) {

        return this.sysUserDao.queryById(userId);
    }
    /**
     * 查詢全部数据
     *
     *
     * @return 列表
     */
    @Override
    public List<SysUser> queryAll(int currentPage) {
        return this.sysUserDao.queryAll( currentPage);
    }


    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getUserId());
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String userId) {
        return this.sysUserDao.deleteById(userId) > 0;
    }
}