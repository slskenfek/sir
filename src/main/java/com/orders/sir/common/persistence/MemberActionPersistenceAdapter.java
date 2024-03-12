package com.orders.sir.common.persistence;

import com.orders.sir.common.config.MemberActionConfigItem;
import lombok.RequiredArgsConstructor;

// 사용자 액션 정보 저장

@RequiredArgsConstructor
public class MemberActionPersistenceAdapter implements MemberActionPort{

    private final MemberActionPersistence memberActionPersistence;

    @Override
    public void save(MemberActionConfigItem memberActionConfigItem) {
        memberActionPersistence.save(ActionEntityModel.of(memberActionConfigItem));
    }
}
