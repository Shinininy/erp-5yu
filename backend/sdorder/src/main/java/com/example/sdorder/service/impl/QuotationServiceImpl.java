package com.example.sdorder.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.*;
import com.example.sdorder.entity.dto.DetailDto;
import com.example.sdorder.entity.dto.QuotationDto;
import com.example.sdorder.mapper.*;
import com.example.sdorder.service.DetailsService;
import com.example.sdorder.service.DiscountRulesService;
import com.example.sdorder.service.MaterialService;
import com.example.sdorder.service.QuotationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * (Quotation)表服务实现类
 */
@Service
public class QuotationServiceImpl implements QuotationService {
    @Autowired
    private QuotationMapper quotationMapper;

    @Autowired
    private InquiryMapper inquiryMapper;

    @Autowired
    private DetailsMapper detailsMapper;

    @Autowired
    private MaterialMapper materialMapper;
    @Autowired
    private DetailsService detailsService;

    @Autowired
    private MaterialService materialService;
    @Autowired
    private DiscountRulesMapper discountRulesMapper;

    @Autowired
    private DiscountRulesService discountRulesService;
    @Override
    public Quotation getQuotationById(Long id) {
        return quotationMapper.selectById(id);
    }

    @Override
    public IPage<Quotation> getPageList(Page page, Quotation quotation) {
        String sql = "select * from quotation where 1=1";
        IPage<Quotation> quotationIPage = quotationMapper.pageList(page, sql);
        return quotationIPage;
    }

    @Override
    @Transactional
    public QuotationDto getAlDiscountrulesAlDetails(Long quotationId){
        Quotation quotation=getQuotationById(quotationId);
        QuotationDto quotationDto=new QuotationDto();
        BeanUtils.copyProperties(quotation,quotationDto);
        List<Details> detailsList=detailsService.getDetailByQuotationId(quotationId);
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
        quotationDto.setDetailDtoList(detailDtoList);
        return quotationDto;
    }


    @Override
    @Transactional
    public long saveQuotation(Quotation quotation, Long batch) {
        if(quotation.getQuotationId()>0)
        {
            quotationMapper.updateById(quotation);
            return quotation.getQuotationId();
        }else{
            List<Details> alDetails = detailsService.getAlDetailsByBatch(batch);
            Optional<Double> reduce = alDetails.stream().map(Details::getNetValue).reduce(Double::sum);

            Double netValue = reduce.get();
            quotation.setNetValue(netValue);
            quotationMapper.insert(quotation);

            long quotationId = quotation.getQuotationId();

            for (Details details : alDetails) {
                details.setQuotationId(quotationId);
                detailsService.saveDetails(details);
            }
            return quotationId;
        }
    }

    @Override
    @Transactional
    public long AddQuotationByInquiryId(Long inquiryId) {
        Quotation quotation = new Quotation();
        Inquiry inquiry = inquiryMapper.selectById(inquiryId);

        BeanUtils.copyProperties(inquiry,quotation);

        quotation.setInquiryId(inquiryId);

        quotationMapper.insert(quotation);

        long quotationId = quotation.getQuotationId();

        List<Details> detailsList = detailsService.getDetailByInquiryId(inquiryId);
        for (Details details : detailsList) {
            long detailId = details.getDetailId();
            details.setDetailId(0);
            details.setInquiryId(0);
            details.setQuotationId(quotationId);
            List<DiscountRules> discountRulesList = discountRulesService.getDiscountRulesByDetailId(detailId);
            detailsMapper.insert(details);
            for (DiscountRules discountRules : discountRulesList) {
                discountRules.setDiscountId(0);
                discountRules.setDetailId(details.getDetailId());
                discountRulesMapper.insert(discountRules);
            }
        }


        return quotationId;
    }

    @Override
    public int deleteQuotation(Long quotationId) {
        return quotationMapper.deleteById(quotationId);
    }
}
