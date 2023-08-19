package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.pojo.Plant;
import com.project.adminbackend.dao.PlantMapper;
import com.project.adminbackend.service.IPlantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlantServiceImpl extends ServiceImpl<PlantMapper, Plant> implements IPlantService {
    @Resource
    private PlantMapper plantMapper;

}
