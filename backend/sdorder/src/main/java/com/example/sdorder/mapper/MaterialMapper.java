package com.example.sdorder.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sdorder.configuration.BaseDao;
import com.example.sdorder.entity.Customer;
import com.example.sdorder.entity.Material;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MaterialMapper extends BaseDao<Material> {
    @Select("select * from material")
    public List<Material> getMaterialList();

    @Select("select customer_id from material")
    public List<Material> getMaterialIdList();
}
