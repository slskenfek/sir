package com.orders.sir.event.adapter.out.persistence;

import com.orders.sir.event.domain.Member;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 데이터베이스 데이터 모델링 작업
 */

@Component
public class MemberModel {

    public Member toDomain(MemberEntity entity) {
        if(entity == null) {
            return null;
        }
        return Member.builder()
                .seq(entity.getSeq())
                .memberId(entity.getMemberId())
                .memberPassword(entity.getMemberPassword())
                .memberAddress(entity.getMemberAddress())
                .memberName(entity.getMemberName())
                .build();
    }
    public List<Member> toListDomain(List<MemberEntity> entity) {
        if(entity.size() == 0) {
            return new ArrayList<>();
        }
        List<Member> domainList = new ArrayList<>();
        for(MemberEntity member : entity) {

            domainList.add(Member.builder()
                    .seq(member.getSeq())
                    .memberId(member.getMemberId())
                    .memberPassword(member.getMemberPassword())
                    .memberAddress(member.getMemberAddress())
                    .memberName(member.getMemberName())
                    .build());
        }

        return domainList;
    }
}
