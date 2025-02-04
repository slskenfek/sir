package com.orders.sir.event.product.adapter.out.persistence;

import com.orders.sir.event.product.adapter.out.Repository.CustomProductRepository;
import com.orders.sir.event.product.application.port.out.ProductLoadPort;
import com.orders.sir.event.product.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductPersisAdapter implements ProductLoadPort {

    private final ProductPersistence productPersistence;

    private final CustomProductRepository customProductRepository;

    @Override
    public void addContent(ProductEntity productEntity) {
        productPersistence.save(productEntity);
    }

    @Override
    public List<ProductDTO.ResponseList> getContentList() {
        return customProductRepository.findByProductList();
    }
}
