package com.orders.sir.event.category.adapter.out.persistence;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.adapter.out.persistence.dsl.CustomCategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CategoryPersistence extends JpaRepository<CategoryEntity, Long>, CustomCategoryRepository {
    Optional<CategoryEntity> findByCategoryId(@Param("categoryId") Long categoryId);
}
