package com.orders.sir.event.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRequest {
        private String productName; //상품명
        private int productPrice; //가격
    }
}
