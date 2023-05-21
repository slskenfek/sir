package com.orders.sir.event.application.service;

import com.orders.sir.event.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import com.orders.sir.event.dto.MemberParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCasePort {
    private final MemberLoadPort memberLoadPort;
    @Override
    public List<MemberDomain> findMemberList() {
      List<MemberDomain> memberList = memberLoadPort.findMemberList();
      return MemberDomain.selectListMember(memberList);
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

    @Override
    public MemberDomain updateMember(Long memberSeq, MemberParam param) {
        //memberLoadPort
        return null;
    }
}
