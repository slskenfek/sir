package com.orders.sir.event.application.port.out;

import com.orders.sir.event.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.domain.MemberDomain;

import java.util.List;

public interface MemberLoadPort {

     List<MemberDomain> findMemberList();
     MemberDomain findMember(Long seq);
    MemberDomain save(MemberEntity param);
}