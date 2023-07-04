package com.orders.sir.event.adapter.in.web;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberUseCasePort memberUseCasePort;


    @GetMapping("")
    public ResponseEntity<List<Member>> findMemberList() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(memberUseCasePort.findMemberList());
    }
    @GetMapping("/app")
    public ResponseEntity findAppMemberList() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(memberUseCasePort.findMemberList());
    }


    @GetMapping("/{memberSeq}")
    public ResponseEntity<Member> findMember(@PathVariable final Long memberSeq) {
        return ResponseEntity.ok().body(memberUseCasePort.findMember(memberSeq));
    }

    @PostMapping("")
    public ResponseEntity<Member> createMember(@RequestBody final Member body) throws Exception {
       Member member = memberUseCasePort.createMember(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(member);
    }

    @PutMapping("/{memberSeq}")
    public ResponseEntity<Member> updateMember(@PathVariable final Long memberSeq, @RequestBody Member body) throws Exception {
        Member modifyMember = memberUseCasePort.updateMember(memberSeq, body);
        return ResponseEntity.ok().body(modifyMember);
    }

    @DeleteMapping("/{memberSeq}")
    public ResponseEntity<String> deleteMember(@PathVariable final Long memberSeq) {
       try {
           memberUseCasePort.deleteMember(memberSeq);
           return ResponseEntity.ok("삭제 완료 되었습니다.");
       }catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 실패 하였습니다." + e.getMessage());
       }
    }


}
