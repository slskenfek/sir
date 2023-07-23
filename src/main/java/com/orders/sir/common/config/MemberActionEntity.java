package com.orders.sir.common.config;


import jakarta.persistence.*;
import lombok.Builder;

@Entity
@Table(name = "member_action")
public class MemberActionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String productId;
    private String memberId;
    private String itemTime;
    private String connectionTime;

    @Builder
    public MemberActionEntity(String productId, String memberId, String itemTime, String connectionTime) {
        this.productId = productId;
        this.memberId = memberId;
        this.itemTime = itemTime;
        this.connectionTime = connectionTime;
    }

    public MemberActionConfigItem memberActionModel(MemberActionConfigItem memberActionConfigItem) {
        return MemberActionConfigItem.builder()
                .productConfigItem(
                        ProductConfigItem.builder()
                        .productId(productId)
                        .build()
                )
                .itemTime(itemTime)
                .connectionTime(connectionTime)
                .memberId(memberId)
                .build();
    }

}
