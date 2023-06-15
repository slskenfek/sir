package com.orders.sir.event.adapter.out.persistence;

import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    @Override
    public MemberDomain update(Long memberSeq, MemberEntity entity) {
        MemberEntity modify = memberPersistence.findById(memberSeq).orElseThrow(() -> new NoSuchFieldError("null member"));
        modify.setMemberId(entity.getMemberId());
        modify.setMemberAddress(entity.getMemberAddress());
        modify.setMemberName(entity.getMemberName());
        MemberEntity resultModify =  memberPersistence.save(modify);
        return memberMapper.toDomain(resultModify);
    }
}
