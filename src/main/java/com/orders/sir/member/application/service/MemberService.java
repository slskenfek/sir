package com.orders.sir.member.application.service;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.application.port.in.MemberUseCasePort;
import com.orders.sir.member.application.port.out.MemberLoadPort;
import com.orders.sir.member.domain.MemberDomain;
import com.orders.sir.member.dto.MemberParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCasePort {
    private final MemberLoadPort memberLoadPort;
    @Override
    public ResponseEntity<List<MemberDomain>> findMemberList() {
      List<MemberDomain> memberList = memberLoadPort.findMemberList();
      return MemberDomain.selectListContent(memberList);
    }

    @Override
    public ResponseEntity<MemberDomain> findMember(Long memberSeq) {
        MemberDomain members = memberLoadPort.findMember(memberSeq);
        return MemberDomain.selectContent(members);
    }

    @Override
    public MemberDomain createMember(MemberEntity param) {
        MemberDomain member = memberLoadPort.save(param);
        return MemberDomain.saveContent(member);
    }
}
