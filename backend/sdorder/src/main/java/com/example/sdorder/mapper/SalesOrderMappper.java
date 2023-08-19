package com.example.sdorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sdorder.configuration.BaseDao;
import com.example.sdorder.entity.SalesOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SalesOrderMappper extends BaseDao<SalesOrder> {
}
