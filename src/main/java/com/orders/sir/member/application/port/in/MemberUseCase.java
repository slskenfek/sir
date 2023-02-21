package com.orders.sir.member.application.port.in;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.domain.MemberDomain;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberUseCase {
    ResponseEntity<List<MemberDomain>> findMemberList();

    ResponseEntity<MemberDomain>  findMember(Long memberSeq);
}
