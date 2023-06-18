package com.orders.sir.event.adapter.out.persistence;

import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
       Optional<MemberEntity> entity = memberPersistence.findById(seq);

        return memberMapper.toDomain(entity.orElse(null));
    }

    @Override
    public MemberDomain save(MemberEntity param) {
        MemberEntity entity = memberPersistence.save(param);
        return memberMapper.toDomain(entity);
    }

    @Transactional
    @Override
    public MemberDomain update(Long memberSeq, MemberEntity entity) {
        MemberEntity modify = memberPersistence.findById(memberSeq).orElseThrow(
                () -> new NoSuchFieldError("회원이 존재 하지 않습니다.")
        );
        modify.setMemberId(entity.getMemberId());
        modify.setMemberAddress(entity.getMemberAddress());
        modify.setMemberName(entity.getMemberName());
        MemberEntity resultModify =  memberPersistence.save(modify);
        return memberMapper.toDomain(resultModify);
    }
}
