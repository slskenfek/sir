package com.orders.sir.aspect;


import com.orders.sir.common.Action;
import com.orders.sir.common.MemberActionService;
import com.orders.sir.event.domain.Member;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;


/**
 * 유저 이벤트 일어났을때 사용자 성향을 저장하는 책임
 */

@Aspect
public class MemberActionSaving {

   private Action action;

   public MemberActionSaving(MemberActionService memberActionService) {
      this.action = memberActionService;
   }

   @Around("execution (* com.orders.sir.*Controller) && args(member)")
   public void saveActionId(Member member) {
      System.out.println("테스크");
      action.saveActionId(member);
   }

}
