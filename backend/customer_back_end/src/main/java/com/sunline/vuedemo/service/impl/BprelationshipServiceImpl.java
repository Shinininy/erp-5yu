package com.sunline.vuedemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sunline.vuedemo.bean.BprelationshipEntity;
import com.sunline.vuedemo.config.PageUtils;
import com.sunline.vuedemo.dao.BprelationshipDao;
import com.sunline.vuedemo.service.BprelationshipService;
import org.springframework.stereotype.Service;
import java.util.Map;


@Service("bprelationshipService")
public class BprelationshipServiceImpl extends ServiceImpl<BprelationshipDao, BprelationshipEntity> implements BprelationshipService {

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<BprelationshipEntity> page = this.page(
//                new Query<BprelationshipEntity>().getPage(params),
//                new QueryWrapper<BprelationshipEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}