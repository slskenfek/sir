package com.orders.sir.event.category.adapter.out.persistence;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.application.port.out.CategoryEventLoadPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CategoryLoadAdapter implements CategoryEventLoadPort {

    private final CategoryPersistence categoryPersistence;

    @Override
    public void saveCategory(CategoryEntity categoryEntity) {
        try {
            categoryPersistence.save(categoryEntity);
        } catch (Exception e) {
            e.getStackTrace();
        }

    }
}
