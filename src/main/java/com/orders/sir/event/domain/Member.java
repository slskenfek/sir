package com.orders.sir.event.domain;

import com.orders.sir.event.adapter.out.persistence.member.MemberEntity;
import com.orders.sir.exception.ExceptionCustom;
import lombok.*;


/**
 * POJO 기반 추상적인 서비스 로직을 가진다.
 * 즉, 로직 변경은 여기서만 이뤄질껏
 */
@Getter
@NoArgsConstructor
public class Member {

    @Builder
    public Member(Long seq, String memberId, String memberName,
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


    public void isMemberId(String memberId) throws ExceptionCustom.ValidationException {
        if( this.memberId.equals(memberId) && memberId != null) {
            throw new ExceptionCustom.ValidationException("회원이 존재 합니다.");
        }
    }

    public MemberEntity entity() {
        return MemberEntity.builder()
                .memberId(this.memberId)
                .memberAddress(this.memberAddress)
                .memberPassword(this.memberPassword)
                .memberName(this.memberName).build();
    }
}
