package com.learnspring.pos_api.dto;

import com.learnspring.pos_api.model.Category;
import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private Integer price;
    private Integer stock;
    private Long categoryId;
}
