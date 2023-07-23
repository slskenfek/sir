package com.orders.sir.common.persistence;

import com.orders.sir.common.config.MemberActionConfigItem;
import com.orders.sir.common.config.MemberActionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberActionPersistence extends JpaRepository<MemberActionEntity, Long> {


}
