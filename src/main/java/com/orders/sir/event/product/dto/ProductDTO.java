package com.orders.sir.event.product.dto;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.product.adapter.out.persistence.ProductDateEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRequest {
        //상품명
        private String productName;
        //가격
        private int productPrice;

        //카테고리 아이디
        private String categoryCode;

        private String productContext;

        public ProductDateEntity toEntity() {
            CategoryEntity categoryEntity = CategoryEntity.builder()
                    .categoryCode(this.categoryCode)
                    .build();

            return ProductDateEntity
                    .builder()
                    .productName(this.productName)
                    .productPrice(this.productPrice)
                    .productContext(this.productContext)
                    .categoryEntity(categoryEntity)
                    .build();

        }
    }

}
