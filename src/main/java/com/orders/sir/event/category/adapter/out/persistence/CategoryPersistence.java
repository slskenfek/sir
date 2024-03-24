package com.orders.sir.event.category.adapter.out.persistence;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.adapter.out.persistence.dsl.CustomCategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryPersistence extends JpaRepository<CategoryEntity, Long>, CustomCategoryRepository {
}
