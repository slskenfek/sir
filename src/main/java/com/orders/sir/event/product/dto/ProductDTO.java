package com.orders.sir.event.product.dto;

import com.orders.sir.event.product.adapter.out.persistence.ProductEntity;
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

        public ProductEntity toEntity() {
            return ProductEntity
                    .builder()
                    .productName(this.productName)
                    .productPrice(this.productPrice)
                    .build();

        }
    }
}
