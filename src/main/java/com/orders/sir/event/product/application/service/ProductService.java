package com.orders.sir.event.product.application.service;


import com.orders.sir.event.product.application.port.in.ProductPort;
import com.orders.sir.event.product.application.port.out.ProductLoadPort;
import com.orders.sir.event.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductPort {

    private final ProductLoadPort productLoadPort;


    @Override
    public void addContent(ProductDTO.AddRequest request) {

    }
}
