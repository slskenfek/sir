package com.orders.sir.event.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class MemberEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    @JsonProperty("member_id")
    private String memberId;
    @JsonProperty("member_name")
    private String memberName;
    @JsonProperty("member_password")
    private String memberPassword;
    @JsonProperty("member_address")
    private String memberAddress;

}
