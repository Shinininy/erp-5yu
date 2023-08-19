package com.example.sdorder.entity.dto;

import com.example.sdorder.entity.Details;
import com.example.sdorder.entity.DiscountRules;
import lombok.Data;

import java.util.List;

@Data
public class DetailDto extends Details {

    private String materialname;
    private double materialprice;
    private double materialnetweight;
    private List<DiscountRules> discountRulesList;
}
