package com.orders.sir.event.product.application.service;


import com.orders.sir.aspect.AspectTargetActions;
import com.orders.sir.event.product.application.port.in.ProductPort;
import com.orders.sir.event.product.application.port.out.ProductLoadPort;
import com.orders.sir.event.product.dto.ProductDTO;
import com.orders.sir.exception.custom.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductPort {

    private final ProductLoadPort productLoadPort;


    @Override
    @Transactional
    public void addContent(ProductDTO.AddRequest request) {
        productLoadPort.addContent(request.toEntity());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductDTO.ResponseList> getContentList() {
        return productLoadPort.getContentList();
    }
}
