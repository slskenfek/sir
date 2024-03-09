package com.orders.sir.event.adapter.out.persistence.team;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "team")
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("team_id")
    private Long seq;

    @JsonProperty("team_name")
    private String teamName;

/*  우선 양방향 매핑 제거

@OneToMany(mappedBy = "teamEntity")
    private List<MemberEntity> memberEntityList = new ArrayList<>();*/

}
