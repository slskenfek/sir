package com.orders.sir.event.category.domain;

import lombok.Getter;

@Getter
public enum CategoryManager {
    GARMENT("A001", "의류");
    private String code;
    private String name;

    CategoryManager(String code, String name) {
        this.code = code;
        this.name = name;
    }

}
