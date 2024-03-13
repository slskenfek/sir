package com.orders.sir.event.category.application.port.in;

import com.orders.sir.event.category.dto.CategoryFindParams;
import com.orders.sir.event.category.dto.CategoryResponse;

public interface CategoryFindPort {

     CategoryResponse.SearchData getCategorySearchList(CategoryFindParams.SearchRequest searchRequest);
}
