package com.orders.sir.event.product.application.port.out;

import com.orders.sir.event.product.adapter.out.persistence.ProductEntity;
import com.orders.sir.event.product.dto.ProductDTO;

import java.util.List;

public interface ProductLoadPort {

    void addContent(ProductEntity productEntity);


    List<ProductDTO.ResponseList> getContentList();
}
