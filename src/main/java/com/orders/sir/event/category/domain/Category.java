package com.orders.sir.event.category.domain;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Category {

    private String categoryName;

    private String categoryCode;

    private Integer depth;

    @Builder
    public Category(String categoryName, String categoryCode, Integer depth) {
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.depth = depth;
    }

    public CategoryEntity toEntity() {
        return CategoryEntity.builder()
                .categoryCode(this.categoryCode)
                .categoryName(this.categoryName)
                .depth(this.depth)
                .build();
    }
}
