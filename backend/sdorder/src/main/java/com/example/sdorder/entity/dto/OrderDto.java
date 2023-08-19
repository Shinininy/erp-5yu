package com.example.sdorder.entity.dto;

import com.example.sdorder.entity.DiscountRules;
import com.example.sdorder.entity.SalesOrder;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto extends SalesOrder {
    private List<DetailDto> detailDtoList;
}
