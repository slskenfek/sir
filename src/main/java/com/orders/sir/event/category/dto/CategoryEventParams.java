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
    public static class UpdateRequest {
        private Long id = null;

        private String categoryName;

        private String categoryCode;

        private Integer depth;

        public UpdateRequest(String categoryName, String categoryCode, Integer depth) {
            this.categoryName = categoryName;
            this.categoryCode = categoryCode;
            this.depth = depth;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }


}
