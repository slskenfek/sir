package com.orders.sir.event.product.adapter.out.persistence;

import com.orders.sir.event.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.product.dto.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {

    @Builder
    public ProductEntity(String productName, Integer productPrice, MemberEntity memberEntity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.memberEntity = memberEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_price")
    private Integer productPrice;

    @JoinColumn(name = "seq")
    @ManyToOne(fetch = FetchType.LAZY)
    private MemberEntity memberEntity;

    public ProductDTO.AddRequest productDTO() {
        return new ProductDTO.AddRequest(
                this.productName,
                this.productPrice);

    }
}
