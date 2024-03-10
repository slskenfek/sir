package com.orders.sir.event.member.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberPersistence extends JpaRepository<MemberEntity,Long> {
     Optional<MemberEntity> findByMemberId(String memberId);
}
