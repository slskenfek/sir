package com.orders.sir.event.category.adapter.out.persistence.dsl;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.dto.CategoryFindParams;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.orders.sir.event.category.adapter.out.QCategoryEntity.categoryEntity;

@Repository
@RequiredArgsConstructor
public class CategoryQuery implements CustomCategoryRepository {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Optional<List<CategoryEntity>> getSearchCategoryList(CategoryFindParams.SearchRequest searchRequest) {
        List<CategoryEntity> category =
                jpaQueryFactory.select(categoryEntity)
                        .from(categoryEntity)
                        .where(searchWhere(searchRequest))
                        .fetch();

        return Optional.ofNullable(category);
    }

    private BooleanExpression searchWhere(CategoryFindParams.SearchRequest searchRequest) {
        return categoryEntity.categoryCode.eq(searchRequest.getCategoryCode())
                .and(categoryEntity.categoryName.eq(searchRequest.getCategoryName()))
                .and(categoryEntity.id.eq(searchRequest.getId()));

    }
}
