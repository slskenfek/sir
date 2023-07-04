package com.orders.sir.event.application.port.in;

import com.orders.sir.event.domain.Member;
import com.orders.sir.exception.ExceptionCustom;

import java.util.List;

public interface MemberUseCasePort {
    List<Member> findMemberList();

    Member findMember(Long memberSeq);

    Member createMember(Member param) throws Exception;

    Member updateMember(Long memberSeq, Member param) throws ExceptionCustom.ValidationException;

    void deleteMember(Long memberSeq);
}
