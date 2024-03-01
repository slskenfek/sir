package com.orders.sir.event.adapter.in.web;


import com.orders.sir.event.application.port.in.CategoryPort;
import com.orders.sir.event.application.port.in.CategoryUseCasePort;
import com.orders.sir.event.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryPort categoryPort;
    private final CategoryUseCasePort categoryUseCasePort;

    public List<Category> getCategoryList() {
      return categoryUseCasePort.getCategoryList();
    }

}
