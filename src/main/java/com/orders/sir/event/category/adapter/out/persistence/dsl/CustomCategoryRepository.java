package com.orders.sir.event.category.adapter.out.persistence.dsl;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.dto.CategoryFindParams;

import java.util.List;
import java.util.Optional;

public interface CustomCategoryRepository {
    Optional<List<CategoryEntity>> getSearchCategoryList(CategoryFindParams.SearchRequest searchRequest);
}
