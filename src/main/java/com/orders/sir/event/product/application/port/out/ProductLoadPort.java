package com.orders.sir.event.product.application.port.out;

import com.orders.sir.event.product.adapter.out.persistence.ProductEntity;

public interface ProductLoadPort {

    void addContent(ProductEntity productEntity);


}
