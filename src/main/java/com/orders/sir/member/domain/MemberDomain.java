package com.orders.sir.member.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


/**
 * POJO 기반 추상적인 서비스 로직을 가진다.
 * 즉, 로직 변경은 여기서만 이뤄질껏
 */
@Getter
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

    /**
     * 컨텐츠 조회
     * @param contents
     * @return
     */
    public static ResponseEntity selectContent(Object contents) {
        return ResponseEntity.ok().body(contents);
    }

    /**
     * 컨텐츠 리스트 조회
     * @param contents
     * @return
     */
    public static ResponseEntity selectListContent(List contents) {
        return ResponseEntity.ok().body(contents);
    }

    public static <T> MemberDomain saveContent(T value) {
        return (MemberDomain) value;
    }
}
