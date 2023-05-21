package com.orders.sir.event.adapter.in.web;

import com.orders.sir.event.adapter.out.persistence.MemberEntity;
import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.application.service.MemberService;
import com.orders.sir.event.domain.MemberDomain;
import com.orders.sir.event.dto.MemberParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 회원들을 관리하는 책임을 가진 컨트롤러
 */

@RestController
@RequestMapping("/api/")
public class MemberController {

    private MemberUseCasePort memberUseCasePort;

    public MemberController(MemberService memberService) {
        this.memberUseCasePort = memberService;
    }

    /**
     * 전체 회원을 조회한다.
     * @return
     * @throws Exception
     */
    @GetMapping("members")
    public ResponseEntity<List<MemberDomain>> findMemberList() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(memberUseCasePort.findMemberList());
    }
    @GetMapping("app/members")
    public ResponseEntity findAppMemberList() throws Exception {
      //  setMemberUseCasePort(new MemberRudService());
        return ResponseEntity.status(HttpStatus.OK).body(memberUseCasePort.findMemberList());
    }

    private void setMemberUseCasePort(MemberUseCasePort memberUseCasePort) {
        this.memberUseCasePort = memberUseCasePort;
    }

    /**
     * 하나의 회원을 조회한다.
     * @param memberSeq
     * @return
     */
    @GetMapping("members/{memberSeq}")
    public ResponseEntity<MemberDomain> findMember(@PathVariable final Long memberSeq) {
        return memberUseCasePort.findMember(memberSeq);
    }

    /**
     * 회원 등록 수행
     * @param param
     * @return
     */
    @PostMapping("members")
    public MemberDomain createMember(@RequestBody final MemberEntity param){
        return memberUseCasePort.createMember(param);
    }

    /**
     * 회원정보 수정
     * @param memberSeq
     * @return
     */
    @PutMapping("members/{memberSeq}")
    public MemberDomain updateMember(@PathVariable final Long memberSeq, @RequestBody MemberParam param){
        return memberUseCasePort.updateMember(memberSeq,param);
    }

}
