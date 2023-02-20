package com.orders.sir.member.application.service;

import com.orders.sir.member.application.port.in.MemberUseCase;
import com.orders.sir.member.adapter.out.persistence.MemberPersistence;
import com.orders.sir.member.dto.MemberReponseList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCase {

    private final MemberPersistence memberPersistence;
    @Override
    public MemberReponseList findMemberList() {
        return null;
    }

    @Override
    public MemberReponseList findMember(String memberId) {
        return null;
    }
}
