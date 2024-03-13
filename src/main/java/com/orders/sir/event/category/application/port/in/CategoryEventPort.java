package com.orders.sir.event.category.application.port.in;

import com.orders.sir.event.category.dto.CategoryEventParams;

public interface CategoryEventPort {

    void addCategory(CategoryEventParams.AddRequest addRequest);

    void updateCategory(CategoryEventParams.UpdateRequest updateRequest);

    void deleteCategory(Long categoryIdx);
}
