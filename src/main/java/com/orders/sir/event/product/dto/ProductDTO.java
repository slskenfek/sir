package com.orders.sir.event.product.dto;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.product.adapter.out.persistence.ProductEntity;
import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
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

        public ProductEntity toEntity() {
            CategoryEntity categoryEntity = CategoryEntity.builder()
                    .categoryCode(this.categoryCode)
                    .build();

            return ProductEntity
                    .builder()
                    .productName(this.productName)
                    .productPrice(this.productPrice)
                    .productContext(this.productContext)
                    .categoryCode(categoryCode)
                    .build();

        }
    }


    @Getter
    @NoArgsConstructor
    public static class ResponseList {
        @QueryProjection
        public ResponseList(String productName, int productPrice, String categoryCode, String productContext) {
            this.productName = productName;
            this.productPrice = productPrice;
            this.categoryCode = categoryCode;
            this.productContext = productContext;
        }

        //상품명
        private String productName;
        //가격
        private int productPrice;

        //카테고리 아이디
        private String categoryCode;

        private String productContext;


    }

}
