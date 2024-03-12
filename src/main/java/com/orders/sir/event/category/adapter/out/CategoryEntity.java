package com.orders.sir.event.category.adapter.out;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "category")
@Entity
@NoArgsConstructor
@Getter
public class CategoryEntity {

    public CategoryEntity(String categoryCode) {
        this.categoryCode = categoryCode;
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
