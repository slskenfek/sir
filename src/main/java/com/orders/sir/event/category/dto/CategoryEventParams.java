package com.orders.sir.event.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryEventParams {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddRequest {
        private String categoryName;

        private String categoryCode;

        private Integer depth;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {
        private Long id;

        private String categoryName;

        private String categoryCode;

        private Integer depth;
    }



}
