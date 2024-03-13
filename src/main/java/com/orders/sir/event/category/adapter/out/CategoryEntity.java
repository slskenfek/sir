package com.orders.sir.event.category.adapter.out;

import com.orders.sir.common.entity.BaseDateAndUserEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "category")
@Entity
@Getter
public class CategoryEntity extends BaseDateAndUserEntity {


    @Builder
    public CategoryEntity(Long id, String categoryName, String categoryCode, Integer depth) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryCode = categoryCode;
        this.depth = depth;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_name", length = 20)
    private String categoryName;

    @Column(name = "category_code", length = 30)
    private String categoryCode;

    @Column(length = 5)
    private Integer depth;


}
