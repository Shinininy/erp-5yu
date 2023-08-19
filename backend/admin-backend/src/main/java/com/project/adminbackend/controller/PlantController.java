package com.project.adminbackend.controller;

import com.project.adminbackend.common.Result;
import com.project.adminbackend.service.IPlantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@CrossOrigin
@RestController
@RequestMapping("/plant")
public class PlantController {
    @Resource
    private IPlantService plantService;

    @GetMapping("/all")   //仓库列表
    public Result findAll(){
        return Result.success(plantService.list());
    }

}
