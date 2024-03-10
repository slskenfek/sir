package com.orders.sir.event.member.application.service;

import com.orders.sir.event.member.application.port.in.MemberUseCasePort;
import com.orders.sir.event.member.application.port.out.MemberLoadPort;
import com.orders.sir.event.member.domain.Member;
import com.orders.sir.exception.ExceptionCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCasePort {
    private final MemberLoadPort memberLoadPort;

    @Override
    public List<Member> findMemberList() {
      return memberLoadPort.findMemberList();
    }

    @Override
    public Member findMember(Long memberSeq) {
        return memberLoadPort.findMember(memberSeq);
    }

    @Override
    public synchronized Member createMember(Member param) throws Exception {
        Member member = memberLoadPort.findMemberId(param.getMemberId());
        if(member != null) {
            member.isMemberId(param.getMemberId());
        }
        return memberLoadPort.save(param.entity());
    }

    @Override
    public Member updateMember(Long memberSeq, Member param) throws ExceptionCustom.ValidationException {
        Member member = memberLoadPort.findMember(memberSeq);
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
