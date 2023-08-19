package com.example.sdorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.Inquiry;
import com.example.sdorder.entity.dto.InQuiryCreatDto;
import org.springframework.transaction.annotation.Transactional;

/**
 * (Inquiry)表服务接口
 */
public interface InquiryService {

    /**
     * 通过id查询inquiry
     * @param id
     * @return
     */
    Inquiry getInquiryById(Long id);

    IPage<Inquiry> getPageList(Page page, Inquiry inquiry);

    /**
     * 一次性完成inquiry创建
     * @param inQuiryCreatDto inquiry创建dto类
     * @return 保存结果
     */
    int saveInquiryAtOnce(InQuiryCreatDto inQuiryCreatDto);

    /**
     * 查找该inquiry所有details与discountrules
     * @param inquiryId
     * @return
     */
    @Transactional
    InQuiryCreatDto getAlDiscountrulesAlDetails(Long inquiryId);

    /**
     * 保存iquiry
     * @param inquiry
     * @param batch
     * @return
     */
    @Transactional
    long saveInquiry(Inquiry inquiry, Long batch);

    /**
     * 删除inquiry
     * @param inquiryId
     * @return
     */
    int  deleteInquiry(Long inquiryId);
}
