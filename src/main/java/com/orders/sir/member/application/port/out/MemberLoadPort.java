package com.orders.sir.member.application.port.out;

import com.orders.sir.member.domain.MemberDomain;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberLoadPort {

     List<MemberDomain> findMemberList();
     MemberDomain findMember(Long seq);
}
