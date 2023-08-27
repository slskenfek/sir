package com.orders.sir.common.persistence;

import com.orders.sir.common.config.MemberActionConfigItem;
import com.orders.sir.common.config.MemberActionEntity;
import org.springframework.stereotype.Component;

public class ActionEntityModel {

    public static MemberActionEntity of(MemberActionConfigItem memberActionConfigItem) {
        return  MemberActionEntity.builder()
                .memberId(memberActionConfigItem.getMemberId())
                .productId(
                        memberActionConfigItem.getProductConfigItem().getProductId()
                )
                .connectionTime(memberActionConfigItem.getConnectionTime())
                .itemTime(memberActionConfigItem.getItemTime())
                .build();

    }

}
