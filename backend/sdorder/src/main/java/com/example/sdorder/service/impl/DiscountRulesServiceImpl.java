package com.example.sdorder.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sdorder.entity.DiscountRules;
import com.example.sdorder.mapper.DiscountRulesMapper;
import com.example.sdorder.service.DiscountRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (DiscountRules)表服务实现类
 */
@Service("DiscountRulesService")
public class DiscountRulesServiceImpl  implements DiscountRulesService {
    @Autowired
    private DiscountRulesMapper discountRulesMapper;

    @Override
    public DiscountRules getDiscountRuleById(Long id) {
        return discountRulesMapper.selectById(id);
    }

    @Override
    public List<DiscountRules> getDiscountRulesByDetailId(Long detailId) {
        List<DiscountRules> discountRulesList = discountRulesMapper.findList("select * from discount_rules where detail_id = '" + detailId + "'");
        return discountRulesList;
    }

    @Override
    public IPage<DiscountRules> getPageList(Page page, DiscountRules rules) {
        String sql = "select * from discount_rules where 1=1";
        IPage<DiscountRules> rulesIPage = discountRulesMapper.pageList(page, sql);
        return rulesIPage;
    }

    @Override
    public int saveRules(DiscountRules rules) {
        if(rules.getDiscountId()>0)
        {
            return discountRulesMapper.updateById(rules);
        }else{
            return discountRulesMapper.insert(rules);
        }
    }

    @Override
    public int deleteRules(Long rulesId) {
        return discountRulesMapper.deleteById(rulesId);
    }
}
