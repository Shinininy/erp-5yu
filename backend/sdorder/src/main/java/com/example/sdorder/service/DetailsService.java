package com.example.sdorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.Details;
import com.example.sdorder.entity.dto.BatchDto;
import com.example.sdorder.entity.dto.DetailDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * (Details)表服务接口
 */
public interface DetailsService {
    /**
     * 分页查询details
     * @param page
     * @param details
     * @return
     */
    IPage<Details> getPageList(Page page, Details details);

    /**
     * 通过id查询detail
     * @param id
     * @return detail
     */
    Details getDetailById(Long id);

    /**
     * 由inquiryId查询details
     * @param inquiryId
     * @return
     */
    List<Details> getDetailByInquiryId(Long inquiryId);

    /**
     * 由quotationId查询details
     * @param quotationId
     * @return
     */
    List<Details> getDetailByQuotationId(Long quotationId);

    /**
     * 有orderId查询details
     * @param orderId
     * @return
     */
    List<Details> getDetailByOrderId(Long orderId);

    /**
     * 初始保存details
     * @param details
     * @return
     */
    int saveDetailsInitial(Details details);

    /**
     *保存details
     * @param details
     * @param
     * @return
     */
    int saveDetails(Details details);


    /**
     * 根据batch返回所有detail与discountrule
     * @param batch
     * @return
     */
    @Transactional
    BatchDto getAlDiscountrulesAlDetails(Long batch);

    /**
     * 通过batch查找details
     * @param batch
     * @return
     */
    List<Details> getAlDetailsByBatch(Long batch);


    /**
     * 通过id删除details
     * @param detailsId
     * @return
     */

    int  deleteDetails(Long detailsId);
}
