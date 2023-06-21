package com.orders.sir.event.application.port.in;

import com.orders.sir.event.domain.MemberDomain;
import com.orders.sir.exception.ExceptionCustom;

import java.util.List;

public interface MemberUseCasePort {
    List<MemberDomain> findMemberList();

    MemberDomain findMember(Long memberSeq);

    MemberDomain createMember(MemberDomain param) throws Exception;

    MemberDomain updateMember(Long memberSeq, MemberDomain param) throws ExceptionCustom.ValidationException;

    void deleteMember(Long memberSeq);
}
