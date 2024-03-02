package com.orders.sir.event.application.port.in;

import com.orders.sir.event.dto.ProductDTO;

public interface ContentPort {

    void addContent(ProductDTO.AddRequest request);
}
