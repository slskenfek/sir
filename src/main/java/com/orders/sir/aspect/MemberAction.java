package com.orders.sir.aspect;


import com.orders.sir.common.service.MemberActionService;
import com.orders.sir.common.config.MemberActionConfigItem;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RequestBody;




@Aspect
@RequiredArgsConstructor
public class MemberAction {

   private final MemberActionService memberActionService;

   @Around("execution (* com.orders.sir.*Controller.*(..)) && args(member)")
   public void saveAction(@RequestBody MemberActionConfigItem request) {
      System.out.println("테스크");
      memberActionService.saveMemberAction(request);
   }

}
