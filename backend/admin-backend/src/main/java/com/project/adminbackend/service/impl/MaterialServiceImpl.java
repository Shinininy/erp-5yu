package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.dao.MaterialMapper;
import com.project.adminbackend.pojo.Material;
import com.project.adminbackend.service.MaterialService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author w
 * @since 2023-07-13
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

}
