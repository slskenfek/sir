package com.orders.sir.event.application.service;


import com.orders.sir.event.application.port.in.ProductPort;
import com.orders.sir.event.application.port.out.ProductLoadPort;
import com.orders.sir.event.dto.ProductDTO;
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
