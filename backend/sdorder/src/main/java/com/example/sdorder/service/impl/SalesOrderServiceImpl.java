package com.example.sdorder.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.*;
import com.example.sdorder.entity.dto.DetailDto;
import com.example.sdorder.entity.dto.OrderDto;
import com.example.sdorder.mapper.*;
import com.example.sdorder.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static java.sql.Types.NULL;

/**
 * (SalesOrder)表服务实现类
 */
@Service
public class SalesOrderServiceImpl implements SalesOrderService {

    @Autowired
    private SalesOrderMappper salesOrderMappper;

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private QuotationService quotationService;
    @Autowired
    private DetailsMapper detailsMapper;

    @Autowired
    private DiscountRulesMapper discountRulesMapper;

    @Autowired
    private DiscountRulesService discountRulesService;

    @Autowired
    private MaterialService materialService;
    @Override
    public  SalesOrder getSalesOrderById(Long id) {
        return salesOrderMappper.selectById(id);
    }

    @Override
    public IPage<SalesOrder> getPageList(Page page, SalesOrder order) {
        String sql = "select * from sales_order where 1=1";
        IPage<SalesOrder> salesOrderIPage = salesOrderMappper.pageList(page, sql);
        return salesOrderIPage;
    }

    @Override
    @Transactional
    public OrderDto getAlDiscountrulesAlDetails(Long orderId){
        SalesOrder salesOrder=getSalesOrderById(orderId);
        OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(salesOrder,orderDto);
        List<Details> detailsList=detailsService.getDetailByOrderId(orderId);
        List<DetailDto> detailDtoList =new ArrayList<>();
        for(Details details:detailsList) {
            DetailDto detailDto=new DetailDto();
            BeanUtils.copyProperties(details,detailDto);
            Material material=materialService.getMaterialById(details.getMaterialId());
            detailDto.setMaterialname(material.getName());
            detailDto.setMaterialprice(material.getPrice());
            detailDto.setMaterialnetweight(material.getNetWeight());
            List<DiscountRules> discountRules=discountRulesService.getDiscountRulesByDetailId(details.getDetailId());
            detailDto.setDiscountRulesList(discountRules);
            detailDtoList.add(detailDto);
        }
        orderDto.setDetailDtoList(detailDtoList);
        return orderDto;
    }

    @Override
    @Transactional
    public long saveOrder(SalesOrder order,Long batch) {
        if(order.getOrderId()>0)
        {
           salesOrderMappper.updateById(order);
           return order.getOrderId();
        }else{
            List<Details> alDetails = detailsService.getAlDetailsByBatch(batch);
            Optional<Double> reduce = alDetails.stream().map(Details::getNetValue).reduce(Double::sum);

            Double netValue = reduce.get();
            order.setNetValue(netValue);
            salesOrderMappper.insert(order);

            long orderId = order.getOrderId();

            for (Details details : alDetails) {
                details.setOrderId(orderId);
                detailsService.saveDetails(details);
            }
            return orderId;
        }

    }


    @Override
    @Transactional
    public long AddOrderByQuotationId(Long quotationId) {
        SalesOrder order = new SalesOrder();
        Quotation quotation = quotationService.getQuotationById(quotationId);

        BeanUtils.copyProperties(quotation,order);

        order.setQuotationId(quotationId);

        salesOrderMappper.insert(order);

        long salesorderId = order.getOrderId();

        List<Details> detailsList = detailsService.getDetailByQuotationId(quotationId);
        for (Details details : detailsList) {
            long detailId = details.getDetailId();
            details.setDetailId(0);
            details.setQuotationId(0);
            details.setOrderId(salesorderId);
            details.setBatch(NULL);
            List<DiscountRules> discountRulesList = discountRulesService.getDiscountRulesByDetailId(detailId);
            detailsMapper.insert(details);
            for (DiscountRules discountRules : discountRulesList) {
                discountRules.setDiscountId(0);
                discountRules.setDetailId(details.getDetailId());
                discountRulesMapper.insert(discountRules);
            }
        }


        return salesorderId;
    }

    @Override
    public int deleteOrder(Long orderId) {

        return salesOrderMappper.deleteById(orderId);
    }
}
