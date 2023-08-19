package com.example.sdorder.entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class BatchDto {
    private List<DetailDto> detailDtoList;
}
