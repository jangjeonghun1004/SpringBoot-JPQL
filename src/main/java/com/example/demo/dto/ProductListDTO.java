package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ProductListDTO {
    List<ProductDTO> productDTOs;
    private int totalPages;
    private long totalElements;
}
