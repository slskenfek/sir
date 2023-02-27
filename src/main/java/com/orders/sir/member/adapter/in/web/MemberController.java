package com.orders.sir.member.adapter.in.web;

import com.orders.sir.member.adapter.out.persistence.MemberEntity;
import com.orders.sir.member.application.port.in.MemberUseCasePort;
import com.orders.sir.member.domain.MemberDomain;
import com.orders.sir.member.dto.MemberParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * 회원들을 관리하는 책임을 가진 컨트롤러
 */

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCasePort memberUseCasePort;

    /**
     * 전체 회원을 조회한다.
     * @return
     * @throws Exception
     */
    @GetMapping("members")
    public ResponseEntity<List<MemberDomain>> findMemberList() throws Exception {
        return memberUseCasePort.findMemberList();
    }

    /**
     * 하나의 회원을 조회한다.
     * @param memberSeq
     * @return
     */
    @GetMapping("members/{memberSeq}")
    public ResponseEntity<MemberDomain> findMember(@PathVariable Long memberSeq) {
        return memberUseCasePort.findMember(memberSeq);
    }

    /**
     * 회원 등록 수행
     * @param param
     * @return
     */
    @PostMapping("members")
    public MemberDomain createMember(@RequestBody MemberEntity param){
        return memberUseCasePort.createMember(param);
    }
}
