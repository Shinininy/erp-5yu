package com.sunline.vuedemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.sunline.vuedemo.bean.BprelationshipEntity;
import com.sunline.vuedemo.bean.ContactpersonEntity;
import com.sunline.vuedemo.bean.CustomersEntity;
import com.sunline.vuedemo.bean.SysUser;
import com.sunline.vuedemo.service.BprelationshipService;
import com.sunline.vuedemo.service.ContactpersonService;
import com.sunline.vuedemo.service.CustomersService;
import com.sunline.vuedemo.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2020-12-22 14:46:19
 */
@RestController
@RequestMapping("sysUser")
@CrossOrigin
@Api("用户表测试")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;
    @Autowired
    private ContactpersonService contactpersonService;
    @Autowired
    private CustomersService customersService;
    @Autowired
    private BprelationshipService bprelationshipService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ApiOperation(value = "通过主键查询单条数据")
    public SysUser selectOne(String id) {

        return this.sysUserService.queryById(id);
    }
    /**
     * 查询全部数据
     *
     *
     * @return 单条数据
     */
    @GetMapping("selectAll")
    @ApiOperation(value = "查询全部数据")
    public List<SysUser> selectAll(int currentPage) {

        return this.sysUserService.queryAll(currentPage);
    }

    @GetMapping("selectCustomers")
    @ApiOperation(value = "查询客户数据")
    public List<CustomersEntity> selectCustomers() {

        return this.customersService.list();
    }

    @GetMapping("selectCustomers2")
    @ApiOperation(value = "查询客户数据")
    public List<CustomersEntity> selectCustomers2(String key,String item) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotBlank(key),"customer_id",key);
        queryWrapper.like(StringUtils.isNotBlank(item),"title",item);
        return this.customersService.list(queryWrapper);
    }

    @GetMapping("selectContactPerson2")
    @ApiOperation(value = "查询客户数据")
    public List<ContactpersonEntity> selectContactPerson2(String key,String item) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotBlank(key),"contact_person_number",key);
        queryWrapper.like(StringUtils.isNotBlank(item),"title",item);
        return this.contactpersonService.list(queryWrapper);
    }

    @GetMapping("selectRelationShip2")
    @ApiOperation(value = "查询客户数据")
    public List<BprelationshipEntity> selectRelationShip2(String key,String item) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq(StringUtils.isNotBlank(key),"relationship_id",key);
        queryWrapper.like(StringUtils.isNotBlank(item),"search_term",item);
        return this.bprelationshipService.list(queryWrapper);
    }

    @GetMapping("selectContactPerson")
    @ApiOperation(value = "查询客户数据")
    public List<ContactpersonEntity> selectContactPerson() {
        return this.contactpersonService.list();
    }

    @GetMapping("selectRelationShip")
    @ApiOperation(value = "查询关系数据")
    public List<BprelationshipEntity> selectRelationShip() {
        return this.bprelationshipService.list();
    }
    /**
     * 新增数据
     *
     * @param contactpersonEntity 实例对象
     * @return 实例对象
     */
    @PostMapping("insert")
    @ApiOperation(value = "新增数据")
    public void insert(ContactpersonEntity contactpersonEntity) {
         this.contactpersonService.save(contactpersonEntity);
    }

    @PostMapping("insertCustomer")
    @ApiOperation(value = "新增客户数据")
    public void insertCustomer(CustomersEntity customersEntity) {
        this.customersService.save(customersEntity);
    }

    @PostMapping("insertRelationShip")
    @ApiOperation(value = "新增关系数据")
    public void insertRelationShip(BprelationshipEntity bprelationshipEntity) {
        this.bprelationshipService.save(bprelationshipEntity);
    }


    /**
     * 修改数据
     *
     * @param userId 实例对象
     * @return 实例对象
     */
    @PostMapping("getCustomerById")
    @ApiOperation(value = "修改数据")
    public CustomersEntity getCustomerById(int userId){
        return this.customersService.getById(userId);
    }
    @PostMapping("getPersonById")
    @ApiOperation(value = "修改数据")
    public ContactpersonEntity getPersonById(String userId){
        return this.contactpersonService.getById(userId);
    }
    @PostMapping("getRelationById")
    @ApiOperation(value = "修改数据")
    public BprelationshipEntity getRelationById(int userId){
        return this.bprelationshipService.getById(userId);
    }
    @PostMapping("update")
    @ApiOperation(value = "修改数据")
     public void update(CustomersEntity sysUser){
        this.customersService.updateById(sysUser);
    }
    @PostMapping("updatePerson")
    @ApiOperation(value = "修改数据")
    public void updatePerson(ContactpersonEntity sysUser){
        this.contactpersonService.updateById(sysUser);
    }
    @PostMapping("updateRelation")
    @ApiOperation(value = "修改数据")
    public void updateRelation(BprelationshipEntity sysUser){
         this.bprelationshipService.updateById(sysUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    @PostMapping("delet")
    @ApiOperation(value = "过主键删除数据")
    public boolean deleteById(String userId) {

        return this.customersService.removeById(userId);
    }

    @PostMapping("deletPerson")
    @ApiOperation(value = "过主键删除数据")
    public boolean deletPerson(String userId) {

        return this.contactpersonService.removeById(userId);
    }

    @PostMapping("deletRelation")
    @ApiOperation(value = "过主键删除数据")
    public boolean deletRelation(String userId) {

        return this.bprelationshipService.removeById(userId);
    }



}