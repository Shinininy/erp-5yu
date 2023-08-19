package com.example.sdorder.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.Material;
import com.example.sdorder.mapper.MaterialMapper;
import com.example.sdorder.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Material)表服务实现类
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMappper;

    @Override
    public IPage<Material> getPageList(Page page, Material material) {
        String sql = "select * from material where 1=1";
        IPage<Material> materialIPage = materialMappper.pageList(page,sql);
        return materialIPage;
    }

    @Override
    public List<Material> getMaterialList() {
        return materialMappper.getMaterialList();
    }

    @Override
    public Material getMaterialById(Long id) {
        return materialMappper.selectById(id);
    }

    @Override
    public int saveMaterial(Material material) {
        if(material.getMaterialId()>0)
        {
            return materialMappper.updateById(material);
        }else{
            return materialMappper.insert(material);
        }

    }

    @Override
    public int deleteMaterial(Long materialId) {
        return materialMappper.deleteById(materialId);
    }
}
