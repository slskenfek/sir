package com.orders.sir.event.application.port.in;

import com.orders.sir.event.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.domain.MemberDomain;
import com.orders.sir.event.dto.MemberParam;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MemberUseCasePort {
    List<MemberDomain> findMemberList();

    ResponseEntity<MemberDomain>  findMember(Long memberSeq);

    MemberDomain createMember(MemberEntity param);

    MemberDomain updateMember(Long memberSeq, MemberParam param);
}
