package com.orders.sir.event.domain;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.util.List;


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
    public static <T> ResponseEntity selectContent(T contents) {
        return ResponseEntity.ok().body(contents);
    }

    /**
     * 맴버 전체 조회
     * @param memberList
     * @return
     */

    public static  List<MemberDomain> selectListMember(List<MemberDomain> memberList) {
        return memberList;
    }

    /**
     * 컨텐츠 추가
     * @param value
     * @return
     * @param <T>
     */
    public static <T> MemberDomain saveContent(T value) {
        return (MemberDomain) value;
    }

    /**
     * 컨텐츠 변경
     *
     * @param updateData
     * @return
     * @param <T>
     */
    public static <T> MemberDomain updateContent(Long seq , T updateData) {
        return null;
    }
}
