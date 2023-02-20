package com.orders.sir.member.application.port.in;

import com.orders.sir.member.dto.MemberReponseList;

public interface MemberUseCase {
    MemberReponseList findMemberList();

    MemberReponseList findMember(String memberId);
}
