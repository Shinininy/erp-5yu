package com.example.sdorder.configuration;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface BaseDao<T>  extends BaseMapper<T> {

	//执行SQL返回对象结果集
	//不select *也可以
	@Select("${sqlStr}")
	public IPage<T> pageList(Page page, @Param(value = "sqlStr") String sqlStr);

	//执行SQL返回对象结果集
	//不select *也可以
	@Select("${sqlStr}")
	public List<T> findList(@Param(value = "sqlStr") String sqlStr);

	//执行SQL返回对象
	//如果结果集多于1条则抛错
	@Select("${sqlStr}")
	public T findObject(@Param(value = "sqlStr") String sqlStr);

	//执行SQL返回MAP
	//如果结果集多于1条则抛错
	@Select("${sqlStr}")
	public Map<String, String> findMap(@Param(value = "sqlStr") String sqlStr);

	//执行SQL返回字符串
	@Select("${sqlStr}")
    public String findString(@Param(value = "sqlStr") String sqlStr);

	//执行insert SQL
	@Insert("${sqlStr}")
    public void insertSql(@Param(value = "sqlStr") String sqlStr);

	//执行update SQL
	@Update("${sqlStr}")
    public void updateSql(@Param(value = "sqlStr") String sqlStr);

	//执行delete SQL
	@Delete("${sqlStr}")
    public void deleteSql(@Param(value = "sqlStr") String sqlStr);



}
