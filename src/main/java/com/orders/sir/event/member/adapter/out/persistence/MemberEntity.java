package com.orders.sir.event.member.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orders.sir.event.team.adapter.out.persistence.TeamEntity;
import jakarta.persistence.*;
import lombok.Builder;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private TeamEntity teamEntity;
    @JsonProperty("member_name")
    private String memberName;
    @JsonProperty("member_password")
    private String memberPassword;
    @JsonProperty("member_address")
    private String memberAddress;

    @Builder
    public MemberEntity(String memberId, TeamEntity teamEntity, String memberName, String memberPassword, String memberAddress) {
        this.memberId = memberId;
      //  this.teamEntity = teamEntity;
        this.memberName = memberName;
        this.memberPassword = memberPassword;
        this.memberAddress = memberAddress;
    }
}
