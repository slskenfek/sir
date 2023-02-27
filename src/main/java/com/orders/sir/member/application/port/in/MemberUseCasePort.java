package com.orders.sir.member.application.port.in;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.domain.MemberDomain;
import com.orders.sir.member.dto.MemberParam;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface MemberUseCasePort {
    ResponseEntity<List<MemberDomain>> findMemberList();

    ResponseEntity<MemberDomain>  findMember(Long memberSeq);

    MemberDomain createMember(MemberEntity param);
}
