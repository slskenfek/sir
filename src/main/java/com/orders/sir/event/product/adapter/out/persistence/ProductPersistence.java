package com.orders.sir.event.product.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductPersistence extends JpaRepository<ProductDateEntity, Long> {
}
