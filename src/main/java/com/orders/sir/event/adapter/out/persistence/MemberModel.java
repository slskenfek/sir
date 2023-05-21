package com.orders.sir.event.adapter.out.persistence;

import com.orders.sir.event.domain.MemberDomain;
import org.springframework.stereotype.Component;

/**
 * 데이터베이스 데이터 모델링 작업
 */

@Component
public class MemberModel {

    public MemberDomain toDomain(MemberEntity entity) {
        return MemberDomain.builder()
                .seq(entity.getSeq())
                .memberId(entity.getMemberId())
                .memberPassword(entity.getMemberPassword())
                .memberAddress(entity.getMemberAddress())
                .memberName(entity.getMemberName())
                .build();
    }

}
