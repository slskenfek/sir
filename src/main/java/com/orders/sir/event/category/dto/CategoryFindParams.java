package com.orders.sir.event.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryFindParams {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchRequest {
        private Long categoryIdx;
        private String categoryName;
        private String categoryCode;
        private Integer depth;
    }

}
