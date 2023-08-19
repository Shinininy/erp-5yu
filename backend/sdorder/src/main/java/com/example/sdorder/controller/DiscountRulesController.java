package com.example.sdorder.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.Details;
import com.example.sdorder.entity.DiscountRules;
import com.example.sdorder.mapper.DiscountRulesMapper;
import com.example.sdorder.service.DetailsService;
import com.example.sdorder.service.DiscountRulesService;
import com.example.sdorder.service.MaterialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * (DiscountRules)表控制层
 */
@RestController
@RequestMapping("discountRules")
public class DiscountRulesController {
    @Autowired
    private DiscountRulesService discountRulesService;

    @Autowired
    private DiscountRulesMapper discountRulesMapper;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private DetailsService detailsService;


    @ApiOperation("分页查询discountrules")
    @GetMapping("getPageList")
    public R<IPage> getPageList(Page page, DiscountRules discountRules){
        IPage<DiscountRules> pageList = discountRulesService.getPageList(page, discountRules);
        return R.success(pageList);
    }

    @ApiOperation("通过id查询discountrules")
    @GetMapping("getDiscountRulesById")
    public R<DiscountRules> getDiscountRulesById(Long id){
        DiscountRules discountRules = discountRulesService.getDiscountRuleById(id);
        return R.success(discountRules);
    }

    @ApiOperation("通过detailId查询discountrules")
    @GetMapping("getDiscountRulesByDetailId")
    public R<List> getDiscountRulesByDetailId(Long detailId){
        List<DiscountRules> list = discountRulesService.getDiscountRulesByDetailId(detailId);
        return R.success(list);
    }


    @ApiOperation("保存discountrules")
    @GetMapping("saveDiscountRules")
    public R<Integer>  saveDiscountRules(DiscountRules discountRules){
        int i = discountRulesService.saveRules(discountRules);
        return R.success(i);
    }

    @ApiOperation("通过detailid保存discountrules，也即新增discountrules并更新details")
    @GetMapping("saveDiscountRulesByDetailId")
    @Transactional
    public R<Integer>  saveDiscountRulesByDetailId(DiscountRules discountRules){
        int i;
        if(discountRules.getDiscountId()>0)
        {
            i=discountRulesMapper.updateById(discountRules);
        }else{
            i = discountRulesService.saveRules(discountRules);
        }
        long detailId = discountRules.getDetailId();
        long materialId = detailsService.getDetailById(detailId).getMaterialId();
        Details details = detailsService.getDetailById(detailId);
        long quantity = details.getQuantity();
        Double price= materialService.getMaterialById(materialId).getPrice();
        Double baifenbi= Double.valueOf(1);
        Double netValue;
        List <DiscountRules> discountRulesList=discountRulesMapper.findList("select * from discount_rules where detail_id = '"+detailId+"'");
        for(DiscountRules discountRules1:discountRulesList)
        {
            if("RA00".equals(discountRules1.getDiscountType()))
            {
                 baifenbi= (baifenbi*discountRules1.getNum())/100;
            } else if ("K004".equals(discountRules1.getDiscountType())) {
                price=price-discountRules1.getNum();
                double youhuihedu=discountRules1.getNum()*quantity;
                BigDecimal zhuanhua = new BigDecimal(youhuihedu);
                double youhuihedu1 = zhuanhua.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                discountRules1.setDiscountAll(youhuihedu1);
                discountRulesMapper.updateById(discountRules1);
            }
        }
        for(DiscountRules discountRules1:discountRulesList)
        {
            if("RA00".equals(discountRules1.getDiscountType()))
            {
                double youhuihedu=price*quantity*(1-(discountRules1.getNum()/100.0));
                BigDecimal zhuanhua = new BigDecimal(youhuihedu);
                double youhuihedu1 = zhuanhua.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
                discountRules1.setDiscountAll(youhuihedu1);
                discountRulesMapper.updateById(discountRules1);
            }
        }
        netValue=price*baifenbi*quantity;
        details.setNetValue(netValue);
        detailsService.saveDetails(details);
        return R.success(i);
    }

    @ApiOperation("删除discountrules")
    @GetMapping("deleteDiscountRules")
    public R<Integer>  deleteDiscountRules(Long discountId){
        int i = discountRulesService.deleteRules(discountId);
        return R.success(i);
    }
}
