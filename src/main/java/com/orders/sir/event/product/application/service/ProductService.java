package com.orders.sir.event.product.application.service;


import com.orders.sir.aspect.AspectTargetActions;
import com.orders.sir.event.product.application.port.in.ProductPort;
import com.orders.sir.event.product.application.port.out.ProductLoadPort;
import com.orders.sir.event.product.dto.ProductDTO;
import com.orders.sir.exception.custom.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductPort {

    private final ProductLoadPort productLoadPort;


    @AspectTargetActions
    @Override
    @Transactional
    public void addContent(ProductDTO.AddRequest request) {
        try {
            productLoadPort.addContent(request.toEntity());
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }
}
