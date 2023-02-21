package com.orders.sir.member.adapter.in.web;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.application.port.in.MemberUseCase;
import com.orders.sir.member.domain.MemberDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 회원들을 관리하는 책임을 가진 컨트롤러
 */

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;

    @GetMapping("members")
    public ResponseEntity<List<MemberDomain>> findMemberList() {
        return memberUseCase.findMemberList();
    }
    @GetMapping("members/{memberId}")
    public ResponseEntity<MemberDomain> findMember(@PathVariable Long memberSeq) {
        return memberUseCase.findMember(memberSeq);
    }
}
