package com.orders.sir.event.product.application.port.in;

import com.orders.sir.event.product.dto.ProductDTO;
import com.orders.sir.exception.custom.ApiException;

public interface ProductPort {

    void addContent(ProductDTO.AddRequest request);
}
