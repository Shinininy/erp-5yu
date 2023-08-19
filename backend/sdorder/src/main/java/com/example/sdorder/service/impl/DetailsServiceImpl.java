package com.example.sdorder.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.Details;
import com.example.sdorder.entity.DiscountRules;
import com.example.sdorder.entity.Material;
import com.example.sdorder.entity.dto.BatchDto;
import com.example.sdorder.entity.dto.DetailDto;
import com.example.sdorder.mapper.DetailsMapper;
import com.example.sdorder.service.DetailsService;
import com.example.sdorder.service.DiscountRulesService;
import com.example.sdorder.service.MaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * (Details)表服务实现类
 */
@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private DetailsMapper detailsMapper;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private DiscountRulesService discountRulesService;


    @Override
    public IPage<Details> getPageList(Page page, Details details) {
        String sql = "select * from details where 1=1";
        IPage<Details> detailsIPage = detailsMapper.pageList(page, sql);
        return detailsIPage;
    }

    @Override
    public Details getDetailById(Long id) {
        return detailsMapper.selectById(id);
    }

    @Override
    public List<Details> getDetailByInquiryId(Long inquiryId) {
        List<Details> detailsList = detailsMapper.findList("select * from details where inquiry_id = '" + inquiryId + "'");
        return detailsList;
    }

    @Override
    public List<Details> getDetailByQuotationId(Long quotationId) {
        List<Details> detailsList = detailsMapper.findList("select * from details where quotation_id = '" + quotationId + "'");
        return detailsList;
    }

    @Override
    public List<Details> getDetailByOrderId(Long orderId) {
        List<Details> detailsList = detailsMapper.findList("select * from details where order_id = '" + orderId + "'");
        return detailsList;
    }

    @Override
    @Transactional
    public int saveDetailsInitial(Details details) {
        if(details.getDetailId()>0)
        {
            return detailsMapper.updateById(details);
        }else{
            Material material = materialService.getMaterialById(details.getMaterialId());
            double price= material.getPrice();
            Double netValue = price*details.getQuantity();
            details.setNetValue(netValue);
            detailsMapper.insert(details);
            return 1;
        }
    }

    @Override
    public int saveDetails(Details details) {
        if(details.getDetailId()>0)
        {
            return detailsMapper.updateById(details);
        }else{
            return detailsMapper.insert(details);
        }
    }

    @Override
    @Transactional
    public BatchDto getAlDiscountrulesAlDetails(Long batch){
        BatchDto batchDto=new BatchDto();
        List<Details> detailsList=getAlDetailsByBatch(batch);
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
        batchDto.setDetailDtoList(detailDtoList);
        return batchDto;
    }

    @Override
    public List<Details> getAlDetailsByBatch(Long batch){
        return detailsMapper.findList("select * from details where batch = '"+batch+"'");
    }

    @Override
    public int deleteDetails(Long detailsId) {
        return detailsMapper.deleteById(detailsId);
    }
}
