package com.orders.sir.event.adapter.out.persistence;

import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MemberPersistenceAdapter implements MemberLoadPort{

    private final MemberModel memberMapper;
    private final MemberPersistence memberPersistence;

    @Override
    public List<MemberDomain> findMemberList() {
        List memberList = memberPersistence.findAll();
        return memberList;
    }

    @Override
    public MemberDomain findMember(Long seq) {
       MemberEntity entity = memberPersistence.findById(seq).orElseThrow(NoSuchFieldError::new);
        return memberMapper.toDomain(entity);
    }

    @Override
    public MemberDomain save(MemberEntity param) {
        MemberEntity entity = memberPersistence.save(param);
        return memberMapper.toDomain(entity);
    }
}
