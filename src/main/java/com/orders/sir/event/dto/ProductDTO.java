package com.orders.sir.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRequest {
        private String productName; //상품명
        private int price; //가격
    }
}
