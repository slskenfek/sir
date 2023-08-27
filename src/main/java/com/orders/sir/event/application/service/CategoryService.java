package com.orders.sir.event.application.service;

import com.orders.sir.event.application.port.in.CategoryPort;
import com.orders.sir.event.application.port.in.CategoryUseCasePort;
import com.orders.sir.event.domain.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryPort, CategoryUseCasePort {

    @Override
    public void addCategoryCode(Category category) {

    }

    @Override
    public List<Category> getCategoryList() {
        return null;
    }
}
