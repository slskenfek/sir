package com.orders.sir.event.application.service;


import com.orders.sir.event.application.port.in.ContentPort;
import com.orders.sir.event.dto.ProductDTO;
import org.springframework.stereotype.Service;

@Service
public class ContentService implements ContentPort {

    @Override
    public void addContent(ProductDTO.AddRequest request) {

    }
}
