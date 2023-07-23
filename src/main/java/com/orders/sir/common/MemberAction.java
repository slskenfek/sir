package com.orders.sir.common;

import com.orders.sir.common.config.MemberActionConfigItem;
import com.orders.sir.common.persistence.MemberActionPort;
import lombok.RequiredArgsConstructor;


// 사용자액션정보
@RequiredArgsConstructor
public class MemberAction {

    private final MemberActionPort memberActionPort;

    public void saveMemberAction(MemberActionConfigItem memberActionConfigItem) {
        memberActionPort.save(memberActionConfigItem);

    }

}
