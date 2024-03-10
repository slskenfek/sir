package com.orders.sir.event.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
