package com.orders.sir.common.service;

import com.orders.sir.common.config.MemberActionConfigItem;
import com.orders.sir.common.persistence.MemberActionPort;
import lombok.RequiredArgsConstructor;


// 사용자액션정보
@RequiredArgsConstructor
public class MemberActionService {

    private final MemberActionPort memberActionPort;

    public void saveMemberAction(MemberActionConfigItem memberActionConfigItem) {
        memberActionPort.save(memberActionConfigItem);

    }

}
