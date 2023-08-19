package com.example.sdorder.entity.dto;

import com.example.sdorder.entity.Quotation;
import lombok.Data;

import java.util.List;

@Data
public class QuotationDto extends Quotation {
    private List<DetailDto> detailDtoList;
}
