package com.orders.sir.event.category.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class CategoryResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchData {
        private CategoryBody content;
    }

    public static class CategoryBody {

        private Long idx;

        private String categoryName;

        private String categoryCode;

        private Integer depth;

    }
}
