package com.example.sdorder.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.Quotation;
import com.example.sdorder.entity.dto.QuotationDto;
import com.example.sdorder.service.QuotationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Quotation)表控制层
 */
@RestController
@RequestMapping("quotation")
public class QuotationController {
    @Autowired
    private QuotationService quotationService;

    @ApiOperation("分页查询quotation")
    @GetMapping("getPageList")
    public R<IPage> getPageList(Page page, Quotation quotation){
        IPage<Quotation> pageList = quotationService.getPageList(page, quotation);
        return R.success(pageList);
    }

    @ApiOperation("通过id查询quotation")
    @GetMapping("getQuotationById")
    public R<Quotation> getQuotationById(Long id){
        Quotation quotation =  quotationService.getQuotationById(id);
        return R.success(quotation);
    }

    @ApiOperation("查询该quotation下所有details与其对应discountrules")
    @GetMapping("getAlDiscountrulesAlDetails")
    public R<QuotationDto> getAlDiscountrulesAlDetails(Long quotationId){
        QuotationDto quotationDto= quotationService.getAlDiscountrulesAlDetails(quotationId);
        return R.success(quotationDto);
    }

    @ApiOperation("保存quotation")
    @GetMapping("saveQuotation")
    public R<Long>  saveQuotation( Quotation quotation,Long batch){
        long quotationId = quotationService.saveQuotation(quotation,batch);
        return R.success(quotationId);
    }

    @ApiOperation("通过inquiryid创建quotation")
    @GetMapping("AddQuotationByInquiryId")
    public R<Long>  AddQuotationByInquiryId(Long inquiryId){
        long quotationId=quotationService.AddQuotationByInquiryId(inquiryId);
        return R.success(quotationId);
    }

    @ApiOperation("删除quotation")
    @GetMapping("deleteQuotation")
    public R<Integer>  deleteQuotation(Long quotationId){
        int i = quotationService.deleteQuotation(quotationId);
        return R.success(i);
    }
}
