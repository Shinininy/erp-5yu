package com.example.sdorder.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.*;
import com.example.sdorder.entity.dto.DetailDto;
import com.example.sdorder.entity.dto.InQuiryCreatDto;
import com.example.sdorder.mapper.InquiryMapper;
import com.example.sdorder.mapper.MaterialMapper;
import com.example.sdorder.service.DetailsService;
import com.example.sdorder.service.DiscountRulesService;
import com.example.sdorder.service.InquiryService;

import com.example.sdorder.service.MaterialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * (Inquiry)表服务实现类
 */
@Service
public class InquiryServiceImpl implements InquiryService {

    @Autowired
    private InquiryMapper inquiryMapper;

    @Autowired
    private DetailsService detailsService;

    @Autowired
    private MaterialService materialService;
    @Autowired
    private DiscountRulesService discountRulesService;

    @Override
    public Inquiry getInquiryById(Long id) {
        return inquiryMapper.selectById(id);
    }

    @Override
    public IPage<Inquiry> getPageList(Page page, Inquiry inquiry) {
        String sql = "select * from inquiry where 1=1";
        IPage<Inquiry> inquiryIPage = inquiryMapper.pageList(page, sql);
        return inquiryIPage;
    }

    @Override
    @Transactional
    public InQuiryCreatDto getAlDiscountrulesAlDetails(Long inquiryId){
        Inquiry inquiry=getInquiryById(inquiryId);
        InQuiryCreatDto inQuiryCreatDto=new InQuiryCreatDto();
        BeanUtils.copyProperties(inquiry,inQuiryCreatDto);
        List<Details> detailsList=detailsService.getDetailByInquiryId(inquiryId);
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
        inQuiryCreatDto.setDetailList(detailDtoList);
        return inQuiryCreatDto;
    }

    @Override
    @Transactional
    public long saveInquiry(Inquiry inquiry, Long batch) {
        if(inquiry.getInquiryId()>0)
        {
            inquiryMapper.updateById(inquiry);
            return inquiry.getInquiryId();
        }else{
            List<Details> alDetails = detailsService.getAlDetailsByBatch(batch);
            Optional<Double> reduce = alDetails.stream().map(Details::getNetValue).reduce(Double::sum);

            Double netValue = reduce.get();
            inquiry.setNetValue(netValue);
            inquiryMapper.insert(inquiry);

            long inquiryId = inquiry.getInquiryId();

            for (Details details : alDetails) {
                details.setInquiryId(inquiryId);
                detailsService.saveDetails(details);
            }
            return inquiryId;
        }

    }

    @Override
    @Transactional
    public int saveInquiryAtOnce(InQuiryCreatDto inQuiryCreatDto) {

        int optionCount = 0;
        if(inQuiryCreatDto.getInquiryId()>0)
        {
            optionCount =  inquiryMapper.updateById(inQuiryCreatDto);
        }else{
            Inquiry inquiry = new Inquiry();
            BeanUtils.copyProperties(inQuiryCreatDto,inquiry);
            optionCount =  inquiryMapper.insert(inquiry);

            long inquiryId = inquiry.getInquiryId();
            List<DetailDto> detailList = inQuiryCreatDto.getDetailList();
            for (DetailDto detailDto : detailList) {
                detailDto.setInquiryId(inquiryId);
                int i = detailsService.saveDetailsInitial(detailDto);

                long detailId = detailDto.getDetailId();
                List<DiscountRules> discountRulesList = detailDto.getDiscountRulesList();
                for (DiscountRules discountRules : discountRulesList) {
                    discountRules.setDetailId(detailId);
                    int i1 = discountRulesService.saveRules(discountRules);
                }
            }
        }



        return optionCount;
    }

    @Override
    public int deleteInquiry(Long inquiryId) {
        return inquiryMapper.deleteById(inquiryId);
    }
}
