package com.orders.sir.aspect;


import com.orders.sir.common.config.MemberActionConfigItem;
import com.orders.sir.common.service.MemberActionService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.RequestBody;


@Aspect
@RequiredArgsConstructor
public class MemberActionSaving {

    private final MemberActionService memberActionService;

    @Around("@annotation(com.orders.sir.aspect.AspectTargetObject)")
    public Object saveAction(@RequestBody MemberActionConfigItem request, ProceedingJoinPoint joinPoint) throws Throwable {
        memberActionService.saveMemberAction(request);
        return joinPoint.proceed();
    }

}
