package com.learnspring.pos_api.dto;

import lombok.Data;

import java.util.List;

@Data
public class TransactionRequest {
    private List<Item> items;

    @Data
    public static class Item {
        private Long productId;
        private Integer qty;
    }
}
