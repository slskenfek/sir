package com.orders.sir.member.adapter.out.persistence;

import com.orders.sir.member.application.port.out.MemberLoadPort;
import com.orders.sir.member.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberPersistenceAdapter implements MemberLoadPort{

    private final MemberMapper memberMapper;
    private final MemberPersistence memberPersistence;

    @Override
    public List<MemberDomain> findMemberList() {
        List memberEntity = memberPersistence.findAll();
        return memberEntity;
    }

    @Override
    public MemberDomain findMember(Long seq) {
       MemberEntity entity = memberPersistence.findById(seq).orElseThrow(NoSuchFieldError::new);
        return memberMapper.toDomain(entity);
    }
}
