package com.orders.sir.event.category.adapter.out.persistence.dsl;

import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.category.dto.CategoryFindParams;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.orders.sir.event.category.adapter.out.QCategoryEntity.categoryEntity;
import static org.springframework.util.StringUtils.hasText;

@Repository
@RequiredArgsConstructor
public class CustomCategoryRepositoryImpl implements CustomCategoryRepository {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public List<CategoryEntity> getCategoryListWithSearch(CategoryFindParams.SearchRequest searchRequest) {
        List<CategoryEntity> category =
                jpaQueryFactory.select(categoryEntity)
                        .from(categoryEntity)
                        .where(searchWhere(searchRequest))
                        .fetch();

        return category;
    }

    private BooleanBuilder searchWhere(CategoryFindParams.SearchRequest searchRequest) {
        BooleanBuilder builder = new BooleanBuilder();
        return builder.and(categoryCodeEa(searchRequest.getCategoryCode()))
                .and(categoryNameEa(searchRequest.getCategoryName()))
                .and(categoryIdEa(searchRequest.getId()))
                .and(categoryCodeEa(searchRequest.getCategoryCode()));

    }


    private BooleanExpression categoryCodeEa(String categoryCode) {
        if (hasText(categoryCode)) {
            System.out.println("입장ㅋ");
            return categoryEntity.categoryCode.eq(categoryCode);
        }
        return null;
    }

    private BooleanExpression categoryNameEa(String categoryName) {
        if (hasText(categoryName)) {
            return categoryEntity.categoryName.eq(categoryName);
        }
        return null;
    }

    private BooleanExpression categoryIdEa(Long categoryId) {
        if (categoryId != null) {
            return categoryEntity.id.eq(categoryId);
        }
        return null;
    }
}
