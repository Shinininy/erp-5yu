package com.sunline.vuedemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunline.vuedemo.bean.CustomersEntity;
import com.sunline.vuedemo.config.PageUtils;
import com.sunline.vuedemo.dao.CustomersDao;
import com.sunline.vuedemo.service.CustomersService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("customersService")
public class CustomersServiceImpl extends ServiceImpl<CustomersDao, CustomersEntity> implements CustomersService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<CustomersEntity> page = this.page(
//                new Query<CustomersEntity>().getPage(params),
//                new QueryWrapper<CustomersEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}