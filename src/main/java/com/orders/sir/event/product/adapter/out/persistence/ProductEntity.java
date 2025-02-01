package com.orders.sir.event.product.adapter.out.persistence;

import com.orders.sir.common.entity.BaseDateEntity;
import com.orders.sir.event.category.adapter.out.CategoryEntity;
import com.orders.sir.event.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.product.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;


@AllArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity extends BaseDateEntity {
    @Builder
    public ProductEntity(String productName, Integer productPrice, MemberEntity memberEntity, String categoryCode, String productContext) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.memberEntity = memberEntity;
        this.categoryCode = categoryCode;
        this.productContext = productContext;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private Integer productPrice;

    @JoinColumn(name = "member_idx", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity memberEntity;

    @Column(name = "category_code")
    public String categoryCode;

    //상품 설명
    @Column(name="product_context", length = 200)
    private String productContext;


    public ProductDTO.AddRequest productDTO() {
        return new ProductDTO.AddRequest(
                this.productName,
                this.productPrice,
                this.categoryCode,
                this.productContext
        );

    }
}
