package com.orders.sir.event.category.adapter.out.persistence;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.application.port.in.CategoryFindPort;
import com.orders.sir.event.category.dto.CategoryFindParams;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryFindLoadAdapter implements CategoryFindPort {

    private final CategoryPersistence categoryPersistence;


    @Override
    public Optional<List<CategoryEntity>> getCategorySearchList(CategoryFindParams.SearchRequest searchRequest) {
        List<CategoryEntity> categoryEntities =
        categoryPersistence.getCategoryListWithSearch(searchRequest);

        return Optional.ofNullable(categoryEntities);

    }

    @Override
    public Optional<CategoryEntity> findByCategoryId(Long id) {
        return categoryPersistence.findById(id);

    }
}
