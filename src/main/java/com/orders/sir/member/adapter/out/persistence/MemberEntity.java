package com.orders.sir.member.adapter.out.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
@Entity
public class MemberEntity{

    @Id
    private Long seq;

}
