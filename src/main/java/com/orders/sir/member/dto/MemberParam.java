package com.orders.sir.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

/**
 * 회원정보 반환정보 바인딩 하는 책임
 */
public class MemberParam {

    public static class idParam {
        @JsonProperty("member_seq")
        private Long memberSeq;
    }

}
