package com.example.sdorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sdorder.configuration.BaseDao;
import com.example.sdorder.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CustomerMapper extends BaseDao<Customer> {

    @Select("select * from customers")
    public List<Customer> getCustomerList();

    @Select("select customer_id from customers")
    public List<Customer> getCustomerIdList();
}
