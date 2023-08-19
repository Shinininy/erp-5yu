package com.sunline.vuedemo.dao;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sunline.vuedemo.bean.ContactpersonEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author Zero
 * @email Zero@gmail.com
 * @date 2023-07-14 21:54:53
 */
@Mapper
public interface ContactpersonDao extends BaseMapper<ContactpersonEntity> {
	
}
