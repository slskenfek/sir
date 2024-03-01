package com.orders.sir.event.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    private String categoryCode;
    private String categoryName;
    private String categoryGroup;

    public Boolean isCategoryCode(String code) {
        return this.categoryCode.equals(code);
    }

}
