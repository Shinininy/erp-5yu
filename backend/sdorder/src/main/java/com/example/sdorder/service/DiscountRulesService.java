package com.example.sdorder.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.DiscountRules;

import java.util.List;

/**
 * (DiscountRules)表服务接口
 */
public interface DiscountRulesService {
    /**
     * 通过id查询DiscountRules
     * @param id
     * @return
     */
    DiscountRules getDiscountRuleById(Long id);

    /**
     * 通过detailId查询discountrules
     * @param detailId
     * @return
     */
    List<DiscountRules> getDiscountRulesByDetailId(Long detailId);

    /**
     * 分页查询折扣细则
     * @param page
     * @param rules
     * @return
     */
    IPage<DiscountRules> getPageList(Page page, DiscountRules rules);

    int saveRules(DiscountRules rules);

    int  deleteRules(Long rulesId);
}
