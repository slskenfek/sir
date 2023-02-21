package com.orders.sir.member.domain;

import lombok.Builder;
import org.springframework.http.ResponseEntity;


/**
 * POJO 기반 로직을 가진다.
 */
public class MemberDomain {

    @Builder
    public MemberDomain(Long seq, String memberId, String memberName,
                        String memberPassword, String memberAddress) {
        this.seq = seq;
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.memberAddress = memberAddress;
    }

    private Long seq;
    private String memberId;
    private String memberName;
    private String memberPassword;
    private String memberAddress;


    public boolean isMemberId() {
        return this.memberId == null;
    }

}
