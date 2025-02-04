package com.orders.sir.event.product.adapter.out.Repository;

import com.orders.sir.event.product.adapter.out.persistence.ProductEntity;
import com.orders.sir.event.product.adapter.out.persistence.QProductEntity;
import com.orders.sir.event.product.dto.ProductDTO;
import com.orders.sir.event.product.dto.QProductDTO_ResponseList;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.beans.Expression;
import java.util.List;

import static com.orders.sir.event.product.adapter.out.persistence.QProductEntity.productEntity;

@Component
@RequiredArgsConstructor
public class CustomProductRepository {

    private final JPAQueryFactory jpaQueryFactory;


    public List<ProductDTO.ResponseList> findByProductList() {
        JPAQuery<ProductDTO.ResponseList> query =  jpaQueryFactory.select(
                new QProductDTO_ResponseList(
                        productEntity.productName,
                        productEntity.productPrice,
                        productEntity.categoryCode,
                        productEntity.productContext
                )
        ).from(productEntity);

        return query.fetch();
    }
}
