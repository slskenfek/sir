package com.orders.sir.event.application.port.in;

import com.orders.sir.event.domain.Category;

import java.util.List;

public interface CategoryUseCasePort {

    List<Category> getCategoryList();

}
