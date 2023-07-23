package com.orders.sir.common.config;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
public class MemberActionConfigItem {

    // 멤버 고유 아이디
    private String memberId;
    //상품 정보
    private ProductConfigItem productConfigItem;
    //대기 시간
    private String itemTime;
    //접속 시간대
    private String connectionTime;

    @Builder
    public MemberActionConfigItem(String memberId, ProductConfigItem productConfigItem, String itemTime, String connectionTime) {
        this.memberId = memberId;
        this.productConfigItem = productConfigItem;
        this.itemTime = itemTime;
        this.connectionTime = connectionTime;
    }


    public MemberActionEntity actionEntityModel() {
      return  MemberActionEntity.builder()
                .memberId(memberId)
                .productId(
                        productConfigItem.getProductId()
                )
                .connectionTime(connectionTime)
                .itemTime(itemTime)
                .build();

    }
}
