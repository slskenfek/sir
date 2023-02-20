package com.orders.sir.member.adapter.in.web;

import com.orders.sir.member.application.port.in.MemberUseCase;
import com.orders.sir.member.dto.MemberReponseList;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 회원들을 관리하는 책임을 가진 컨트롤러
 */

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;

    @GetMapping("members")
    public MemberReponseList findMemberList() {
        return memberUseCase.findMemberList();
    }
    @GetMapping("members/{memberId}")
    public MemberReponseList findMember(@PathVariable String MemberId) {
        return memberUseCase.findMember(MemberId);
    }
}
