package com.orders.sir.event.category.application.port.out;

import com.orders.sir.event.category.adapter.out.CategoryEntity;

public interface CategoryEventLoadPort {

    void saveCategory(CategoryEntity categoryEntity);
}
