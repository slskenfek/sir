package com.orders.sir.member.adapter.in.web;

import com.orders.sir.member.application.port.in.MemberUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * 회원들을 관리하는 책임을 가진 컨트롤러
 */

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberUseCase memberUseCase;


}
