package com.project.adminbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.adminbackend.dao.InvoiceMapper;
import com.project.adminbackend.pojo.Invoice;
import com.project.adminbackend.service.InvoiceService;
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
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

}
