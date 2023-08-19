package com.example.sdorder.entity.dto;

import com.example.sdorder.entity.Inquiry;
import lombok.Data;

import java.util.List;

@Data
public class InQuiryCreatDto extends Inquiry {
    private List<DetailDto> detailList;
}
