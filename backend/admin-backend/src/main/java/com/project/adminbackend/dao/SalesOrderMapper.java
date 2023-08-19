package com.project.adminbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.adminbackend.pojo.SalesOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SalesOrderMapper extends BaseMapper<SalesOrder> {
    Page<SalesOrder> findPage(Page<SalesOrder> page,
                              @Param("orderId") Integer orderId,
                              @Param("shipToParty") Integer shipToParty,
                              @Param("start") String start,
                              @Param("end") String end
                         );
}
