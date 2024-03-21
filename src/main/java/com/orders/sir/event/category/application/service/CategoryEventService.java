package com.orders.sir.event.category.application.service;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.application.port.in.CategoryEventPort;
import com.orders.sir.event.category.application.port.in.CategoryFindPort;
import com.orders.sir.event.category.application.port.out.CategoryEventLoadPort;
import com.orders.sir.event.category.domain.Category;
import com.orders.sir.event.category.dto.CategoryEventParams;
import com.orders.sir.exception.custom.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryEventService implements CategoryEventPort {

    private final CategoryEventLoadPort categoryEventLoadPort;

    private final CategoryFindPort categoryFindPort;

    @Override
    public void addCategory(CategoryEventParams.AddRequest addRequest) {
        try {
            Category category = Category.builder()
                    .categoryCode(addRequest.getCategoryCode())
                    .categoryName(addRequest.getCategoryName())
                    .depth(addRequest.getDepth()).build();

            categoryEventLoadPort.saveCategory(category.toEntity());
        } catch (Exception e) {
            throw new ApiException(e.getMessage() + "  #카테고리 저장중 예외");
        }
    }

    @Transactional
    @Override
    public void updateCategory(CategoryEventParams.UpdateRequest updateRequest) {
        try {
            Optional<CategoryEntity> categoryEntity =
                    categoryFindPort.findByCategoryId(updateRequest.getId());

            if (categoryEntity.isPresent()) {
                CategoryEntity category = categoryEntity.get();
                category.setCategoryCode(updateRequest.getCategoryCode());
                category.setCategoryName(updateRequest.getCategoryName());
                category.setDepth(updateRequest.getDepth());
            } else {
                throw new NoSuchFieldException("변경할 카테고리가 검색되지 않습니다.");
            }

        } catch (NoSuchFieldException e) {
            throw new ApiException(e.getMessage());

        } catch (Exception e) {
            throw new ApiException(e.getMessage() + " #수정중 예외발생");
        }


    }

    @Override
    public void deleteCategory(Long categoryIdx) {

    }
}
