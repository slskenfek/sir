package com.orders.sir.event.product.adapter.out.persistence;

import com.orders.sir.event.product.application.port.out.ProductLoadPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductPersisAdapter implements ProductLoadPort {

    private final ProductPersistence productPersistence;

    @Override
    public void addContent(ProductDateEntity productEntity) {
        productPersistence.save(productEntity);
    }
}
