package com.orders.sir.event.dto;

import com.orders.sir.event.adapter.out.persistence.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원정보 반환정보 바인딩 하는 책임
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponse {

    private Long memberSeq;
    private String memberId;
    private String memberName;
    private String memberPassword;
    private String memberAddress;


}
