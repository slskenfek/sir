package com.orders.sir.member.application.port.out;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.domain.MemberDomain;
import com.orders.sir.member.dto.MemberParam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MemberLoadPort {

     List<MemberDomain> findMemberList();
     MemberDomain findMember(Long seq);

    MemberDomain save(MemberEntity param);
}
