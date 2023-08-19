package com.project.adminbackend.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.adminbackend.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *   查询Stock库存信息的Mapper接口
 * @author w
 * @since 2023-07-13
 */

@Mapper
public interface StockMapper extends BaseMapper<Stock> {

    List<Integer> queryStockId(@Param("materialId") Integer materialId, @Param("plantId") Integer plantId, @Param("storageLocation") String storageLocation);

    @Select("select s.stock_id from stock s inner join material m on s.material_id = #{materialId} group by s.stock_id")
    List<Integer> queryStockByMaterialId(@Param("materialId") Integer materialId);

    @Select("select s.stock_id from plant p inner join stock s on s.plant_id in (select plant_id from plant where storage_location = #{storageLocation}) group by s.stock_id;")
    List<Integer> queryStockByStorageLocation(@Param("storageLocation") String storageLocation);

    @Select("select s.stock_id from plant p inner join stock s on s.plant_id in (select plant_id from plant where storage_location = #{storageLocation}) inner join material m on s.material_id = #{materialId} group by s.stock_id;")
    List<Integer> queryStockByStorageLocationAndMaterialId(@Param("storageLocation") String storageLocation, @Param("materialId") Integer materialId);

    /**
     * 得到stock的详细信息
     * @param idList
     * @return
     */
    List<Map<String, Object>> queryStockInfo(List<Integer> idList);
}
