package com.orders.sir.common;

import com.orders.sir.event.adapter.out.persistence.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionPersistence extends JpaRepository<MemberEntity,Long> {
}
