package com.orders.sir.event.category.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CategoryFindParams {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    public static class SearchRequest {
        private String categoryName;
        private String categoryCode;
        private Integer depth;
        private Long id;
    }

}
