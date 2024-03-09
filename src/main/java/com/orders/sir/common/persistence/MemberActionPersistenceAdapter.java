package com.orders.sir.common.persistence;

import com.orders.sir.common.config.MemberActionConfigItem;
import lombok.RequiredArgsConstructor;

// 사용자 액션 정보를 [역할# JPA를 이용하여 저장] 저장하라

@RequiredArgsConstructor
public class MemberActionPersistenceAdapter implements MemberActionPort{

    private final MemberActionPersistence memberActionPersistence;

    @Override
    public void save(MemberActionConfigItem memberActionConfigItem) {
        memberActionPersistence.save(ActionEntityModel.of(memberActionConfigItem));
    }
}
