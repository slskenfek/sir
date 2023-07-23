package com.orders.sir.common.config;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProductConfigItem {

    private String productId;

    @Builder
    public ProductConfigItem(String productId) {
        this.productId = productId;
    }
}
