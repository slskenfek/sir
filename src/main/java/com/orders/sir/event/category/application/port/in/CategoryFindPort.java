package com.orders.sir.event.category.application.port.in;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.dto.CategoryFindParams;
import com.orders.sir.event.category.dto.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryFindPort {

     List<CategoryEntity> getCategorySearchList(CategoryFindParams.SearchRequest searchRequest);

     Optional<CategoryEntity> findByCategoryId(Long id);
}
