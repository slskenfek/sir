package com.orders.sir.member.adapter.out.persistence;

import com.orders.sir.member.domain.MemberDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberPersistence extends JpaRepository<MemberEntity,Long> {
}
