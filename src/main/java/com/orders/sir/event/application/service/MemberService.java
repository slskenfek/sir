package com.orders.sir.event.application.service;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import com.orders.sir.exception.ExceptionCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCasePort {
    private final MemberLoadPort memberLoadPort;
    @Override
    public List<MemberDomain> findMemberList() {
      return memberLoadPort.findMemberList();
    }

    @Override
    public MemberDomain findMember(Long memberSeq) {
        return memberLoadPort.findMember(memberSeq);
    }

    @Override
    public MemberDomain createMember(MemberDomain param) throws Exception {
        MemberDomain member = memberLoadPort.findMemberId(param.getMemberId());
        if(member != null) {
            member.isMemberId(param.getMemberId());
        }

        return memberLoadPort.save(param.entity());
    }

    @Override
    public MemberDomain updateMember(Long memberSeq, MemberDomain param) throws ExceptionCustom.ValidationException {
        MemberDomain member = memberLoadPort.findMember(memberSeq);
        if(member != null) {
            member.isMemberId(param.getMemberId());
        }
        return memberLoadPort.update(memberSeq, param.entity());
    }

    @Override
    public void deleteMember(Long memberSeq) {
         memberLoadPort.deleteMember(memberSeq);
    }
}
