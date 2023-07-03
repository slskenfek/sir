package com.orders.sir.event.application.service;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.application.port.out.MemberLoadPort;
import com.orders.sir.event.domain.MemberDomain;
import com.orders.sir.exception.ExceptionCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@RequiredArgsConstructor
public class MemberService implements MemberUseCasePort {
    private final MemberLoadPort memberLoadPort;

    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition accessCondition = lock.newCondition();

    @Override
    public List<MemberDomain> findMemberList() {
      return memberLoadPort.findMemberList();
    }

    @Override
    public MemberDomain findMember(Long memberSeq) {
        return memberLoadPort.findMember(memberSeq);
    }

    @Override
    public MemberDomain createMember(MemberDomain param) throws Exception {
        System.out.println(param.getMemberId() + "현재 들어온 memberId");
        lock.lock();
        try{
        count ++;
        while(count > 1) {
           try{
               accessCondition.await();
               System.out.println("대기중인 값" + param.getMemberId());
           }catch (InterruptedException  e) {
               Thread.currentThread().interrupt(); //스레드 인터럽터
           }

        }

        MemberDomain member = memberLoadPort.findMemberId(param.getMemberId());
        if(member != null) {
            member.isMemberId(param.getMemberId());
        }
        System.out.println(count + ": count 값");
        count --;
        accessCondition.signalAll();
        }finally {
            lock.unlock();
        }
        return memberLoadPort.save(param.entity());
    }

    @Override
    public MemberDomain updateMember(Long memberSeq, MemberDomain param) throws ExceptionCustom.ValidationException {
        MemberDomain member = memberLoadPort.findMember(memberSeq);
        if(member != null) {
            member.isMemberId(param.getMemberId());
        }
        return memberLoadPort.update(memberSeq, param.entity());
    }

    @Override
    public void deleteMember(Long memberSeq) {
         memberLoadPort.deleteMember(memberSeq);
    }
}
