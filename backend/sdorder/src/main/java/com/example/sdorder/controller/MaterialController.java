package com.example.sdorder.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.Material;
import com.example.sdorder.service.MaterialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Material)表控制层
 */
@RestController
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @ApiOperation("分页查询material")
    @GetMapping("getPageList")
    public R<IPage> getPageList(Page page, Material material){
        IPage<Material> pageList = materialService.getPageList(page, material);
        return R.success(pageList);
    }

    @ApiOperation("根据id查询material")
    @GetMapping("getMaterialById")
    public R<Material> getMaterialById(Long id){
        Material material = materialService.getMaterialById(id);
        return R.success(material);
    }

    @ApiOperation("查询所有material以列表返回")
    @GetMapping("getMaterialList")
    public R<List<Material>> getMaterialList(){
        List<Material> list = materialService.getMaterialList();
        return R.success(list);
    }

    @ApiOperation("保存material")
    @GetMapping("saveMaterial")
    public R<Integer>  saveOrder(Material material){
        int i = materialService.saveMaterial(material);
        return R.success(i);
    }

    @ApiOperation("删除material")
    @GetMapping("deleteMaterial")
    public R<Integer>  deleteOrder(Long materialId){
        int i = materialService.deleteMaterial(materialId);
        return R.success(i);
    }
}
