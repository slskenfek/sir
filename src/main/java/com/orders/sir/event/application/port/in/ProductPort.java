package com.orders.sir.event.application.port.in;

import com.orders.sir.event.dto.ProductDTO;

public interface ProductPort {

    void addContent(ProductDTO.AddRequest request);
}
