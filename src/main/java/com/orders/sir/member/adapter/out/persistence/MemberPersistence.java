package com.orders.sir.member.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPersistence extends JpaRepository<MemberEntity,Long> {


}
