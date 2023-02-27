package com.orders.sir.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원정보 반환정보 바인딩 하는 책임
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberParam {

    private String memberId;
    private String memberName;
    private String memberPassword;
    private String memberAddress;

}
