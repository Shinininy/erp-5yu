package com.example.sdorder.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.Inquiry;
import com.example.sdorder.entity.dto.InQuiryCreatDto;
import com.example.sdorder.service.InquiryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Inquiry)表控制层
 */
@RestController
@RequestMapping("inquiry")
public class InquiryController {

    @Autowired
    private InquiryService inquiryService;


    @ApiOperation("分页查询inquiry")
    @GetMapping("getPageList")
    public R<IPage> getPageList(Page page, Inquiry inquiry){
        IPage<Inquiry> pageList = inquiryService.getPageList(page, inquiry);
        return R.success(pageList);
    }

    @ApiOperation("通过id查询inquiry")
    @GetMapping("getInquiryById")
    public R<Inquiry> getInquiryById(Long id){
        Inquiry inquiry = inquiryService.getInquiryById(id);
        return R.success(inquiry);
    }

    @ApiOperation("查询该inquiry下所有details与其对应discountrules")
    @GetMapping("getAlDiscountrulesAlDetails")
    public R<InQuiryCreatDto> getAlDiscountrulesAlDetails(Long inquiryId){
        InQuiryCreatDto inQuiryCreatDto= inquiryService.getAlDiscountrulesAlDetails(inquiryId);
        return R.success(inQuiryCreatDto);
    }

    @ApiOperation("保存inquiry")
    @GetMapping("saveInquiry")
    public R<Long>  saveInquiry(Inquiry inquiry, Long batch){
        long inquiryId = inquiryService.saveInquiry(inquiry,batch);
        return R.success(inquiryId);
    }

    @ApiOperation("【一般不用】保存inquiry")
    @PostMapping("saveInquiryAtOnce")
    public R<Integer>  saveInquiryAtOnce(@RequestBody  InQuiryCreatDto inQuiryCreatDto){
        int i = inquiryService. saveInquiryAtOnce(inQuiryCreatDto);
        return R.success(i);
    }

    @ApiOperation("删除inquiry")
    @GetMapping("deleteInquiry")
    public R<Integer>  deleteInquiry(Long inquiryId){
        int i = inquiryService.deleteInquiry(inquiryId);
        return R.success(i);
    }
}
