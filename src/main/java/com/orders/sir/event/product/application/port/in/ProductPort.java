package com.orders.sir.event.product.application.port.in;

import com.orders.sir.event.product.dto.ProductDTO;

public interface ProductPort {

    void addContent(ProductDTO.AddRequest request);
}
