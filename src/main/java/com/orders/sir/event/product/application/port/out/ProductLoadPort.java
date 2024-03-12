package com.orders.sir.event.product.application.port.out;

import com.orders.sir.event.product.adapter.out.persistence.ProductDateEntity;

public interface ProductLoadPort {

    void addContent(ProductDateEntity productEntity);


}
