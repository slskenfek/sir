package com.orders.sir.common.persistence;

import com.orders.sir.common.config.MemberActionConfigItem;

public interface MemberActionPort {

    void save(MemberActionConfigItem memberActionConfigItem);

}
