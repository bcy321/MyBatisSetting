package com.example.mybatissetting.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private int productId;
    private String productName;
    private int productTotalCount;
    private String productCategory;
    private String productSize;
    private String productColor;
    private String productImg;
}
