package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.dao.StockMapper;
import com.project.adminbackend.pojo.Stock;
import com.project.adminbackend.service.StockService;
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
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {

}
