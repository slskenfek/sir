package com.orders.sir.event.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPersistence extends JpaRepository<MemberEntity,Long> {
}
