package com.orders.sir.aspect;


import com.orders.sir.common.MemberAction;
import com.orders.sir.common.config.MemberActionConfigItem;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * 유저 이벤트 일어났을때 사용자 성향을 저장하는 책임
 */

@Aspect
@RequiredArgsConstructor
public class MemberActionSaving  {

   private final MemberAction memberAction;

   @Around("execution (* com.orders.sir.*Controller.*(..)) && args(member)")
   public void saveAction(@RequestBody MemberActionConfigItem request) {
      System.out.println("테스크");
      memberAction.saveMemberAction(request);
   }

}
