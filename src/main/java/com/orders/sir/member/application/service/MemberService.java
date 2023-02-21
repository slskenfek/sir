package com.orders.sir.member.application.service;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.application.port.in.MemberUseCase;
import com.orders.sir.member.adapter.out.persistence.MemberPersistence;
import com.orders.sir.member.application.port.out.MemberLoadPort;
import com.orders.sir.member.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {
    private final MemberLoadPort memberLoadPort;
    @Override
    public ResponseEntity<List<MemberDomain>> findMemberList() {
      List<MemberDomain> memberList = memberLoadPort.findMemberList();
      return ResponseEntity.ok().body(memberList);
    }

    @Override
    public ResponseEntity<MemberDomain> findMember(Long memberSeq) {
        MemberDomain members = memberLoadPort.findMember(memberSeq);
        if(members.isMemberId()) {
            throw new NullPointerException();
        }
        return ResponseEntity.ok().body(members);
    }
}
