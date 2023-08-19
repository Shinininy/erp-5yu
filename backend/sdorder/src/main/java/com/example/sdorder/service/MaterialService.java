package com.example.sdorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.Material;

import java.util.List;


/**
 * (Material)表服务接口
 */
public interface MaterialService {

    /**
     * 分页查询material数据
     * @param page
     * @param material
     * @return
     */
    IPage<Material> getPageList(Page page, Material material);

    /**
     * 查询所有material数据
     * @return 所有material数据
     */
    List<Material> getMaterialList();

    /**
     * 通过id查询物料
     * @param id
     * @return
     */
    Material getMaterialById(Long id);

    /**
     * 保存物料
     * @param material
     * @return
     */
    int saveMaterial(Material material);

    /**
     * 根据id删除material
     * @param materialId
     * @return
     */
    int  deleteMaterial(Long materialId);
}
