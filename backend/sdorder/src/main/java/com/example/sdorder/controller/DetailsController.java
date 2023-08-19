package com.example.sdorder.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.configuration.R;
import com.example.sdorder.entity.Details;
import com.example.sdorder.entity.dto.BatchDto;
import com.example.sdorder.entity.dto.OrderDto;
import com.example.sdorder.service.DetailsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Details)表控制层
 */
@RestController
@RequestMapping("details")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;


    @ApiOperation("分页查询details")
    @GetMapping("getPageList")
    public R<IPage> getPageList(Page page, Details details){
        IPage<Details> pageList = detailsService.getPageList(page, details);
        return R.success(pageList);
    }

    @ApiOperation("通过id查询details")
    @GetMapping("getDetailsById")
    public R<Details> getDetailsById(Long id){
        Details details = detailsService.getDetailById(id);
        return R.success(details);
    }

    @ApiOperation("通过inquiryId查询details")
    @GetMapping("getDetailByInquiryId")
    public R<List> getDetailByInquiryId(Long inquiryId){
        List<Details> list = detailsService.getDetailByInquiryId(inquiryId);
        return R.success(list);
    }

    @ApiOperation("通过quotationId查询details")
    @GetMapping("getDetailByQuotationId")
    public R<List> getDetailByQuotationId(Long quotationId){
        List<Details> list = detailsService.getDetailByQuotationId(quotationId);
        return R.success(list);
    }

    @ApiOperation("通过orderId查询details")
    @GetMapping("getDetailByOrderId")
    public R<List> getDetailByOrderId(Long orderId){
        List<Details> list = detailsService.getDetailByOrderId(orderId);
        return R.success(list);
    }


    @ApiOperation("初始保存details，伴随初始net_value赋值")
    @GetMapping("saveDetailsInitial")
    public R<Integer>  saveDetailsInitial(Details details){
        int i = detailsService.saveDetailsInitial(details);
        return R.success(i);
    }

    @ApiOperation("【一般不用】保存details")
    @GetMapping("saveDetails")
    public R<Integer>  saveDetails(Details details){
        int i = detailsService.saveDetails(details);
        return R.success(i);
    }

    @ApiOperation("通过batch查询details")
    @GetMapping("getAlDetailsByBatch")
    public R<List> getAlDetailsByBatch(Long batch){
        List<Details> list=detailsService.getAlDetailsByBatch(batch);
        return R.success(list);
    }

    @ApiOperation("通过batch查询details与其对应discountrules")
    @GetMapping("getAlDiscountrulesAlDetails")
    public R<BatchDto> getAlDiscountrulesAlDetails(Long batch){
        BatchDto batchDto= detailsService.getAlDiscountrulesAlDetails(batch);
        return R.success(batchDto);
    }

    @ApiOperation("删除details")
    @GetMapping("deleteDetails")
    public R<Integer>  deleteDetails(Long detailsId){
        int i = detailsService.deleteDetails(detailsId);
        return R.success(i);
    }

}
