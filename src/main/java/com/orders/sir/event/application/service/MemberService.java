package com.orders.sir.event.application.service;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCasePort {
    private final MemberLoadPort memberLoadPort;
    @Override
    public List<MemberDomain> findMemberList() {
      List<MemberDomain> memberList = memberLoadPort.findMemberList();
      return memberList;
    }

    @Override
    public MemberDomain findMember(Long memberSeq) {
        MemberDomain members = memberLoadPort.findMember(memberSeq);
        return members;
    }

    @Override
    public MemberDomain createMember(MemberDomain param) throws Exception {
        MemberDomain member = memberLoadPort.findMember(param.getSeq());
        member.isMemberId(param.getMemberId());
        return memberLoadPort.save(param.entity());
    }

    @Override
    public MemberDomain updateMember(Long memberSeq, MemberDomain param) throws Exception {
        MemberDomain member = memberLoadPort.findMember(param.getSeq());
        member.isMemberId(param.getMemberId());
        return memberLoadPort.update(memberSeq, param.entity());
    }
}
