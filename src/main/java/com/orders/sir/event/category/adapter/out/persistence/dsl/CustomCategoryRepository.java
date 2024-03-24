package com.orders.sir.event.category.adapter.out.persistence.dsl;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.dto.CategoryFindParams;

import java.util.List;


public interface CustomCategoryRepository {
    List<CategoryEntity> getCategoryListWithSearch(CategoryFindParams.SearchRequest searchRequest);
}
