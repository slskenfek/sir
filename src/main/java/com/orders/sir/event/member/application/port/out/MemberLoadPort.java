package com.orders.sir.event.member.application.port.out;

import com.orders.sir.event.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.member.domain.Member;

import java.util.List;

public interface MemberLoadPort {

     List<Member> findMemberList();
     Member findMember(Long seq);
     Member findMemberId(String memberId);
     Member save(MemberEntity param);
     Member update(Long memberSeq, MemberEntity entity);
     void deleteMember(Long memberSeq);
}
