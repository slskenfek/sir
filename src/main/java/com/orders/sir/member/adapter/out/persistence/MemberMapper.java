package com.orders.sir.member.adapter.out.persistence;

import com.orders.sir.member.domain.MemberDomain;
import org.springframework.stereotype.Component;

/**
 * 데이터베이스 데이터 모델링 작업
 */

@Component
public class MemberMapper {

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
