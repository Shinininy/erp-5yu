package com.example.sdorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sdorder.entity.Quotation;
import com.example.sdorder.entity.dto.QuotationDto;
import org.springframework.transaction.annotation.Transactional;


/**
 * (Quotation)表服务接口
 */
public interface QuotationService {
    /**
     * 通过id查询Quotation
     * @param id
     * @return
     */
    Quotation getQuotationById(Long id);

    /**
     * 分页查询quotation
     * @param page
     * @param quotation
     * @return
     */
    IPage<Quotation> getPageList(Page page, Quotation quotation);

    /**
     * 查找该quotation所有details与discountrules
     * @param quotationId
     * @return
     */
    @Transactional
    QuotationDto getAlDiscountrulesAlDetails(Long quotationId);

    /**
     * 保存quotation
     * @param quotation
     * @param batch
     * @return
     */
    long saveQuotation(Quotation quotation, Long batch);

    /**
     * 通过inquiry创建quotation
     * @param inquiryId
     * @return
     */
    long AddQuotationByInquiryId(Long inquiryId);

    /**
     * 删除quotation
     * @param quotationId
     * @return
     */
    int  deleteQuotation(Long quotationId);
}
