package com.orders.sir.event.team.adapter.out.persistence;


import com.orders.sir.event.team.application.port.out.TeamLoadPort;
import com.orders.sir.event.team.domain.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TeamPersitenceAdapter implements TeamLoadPort {

    private TeamPersistence teamPersistence;


    @Override
    public List<Team> getTeamList() {
       List<TeamEntity> teamList = teamPersistence.findAll();


        return null;
    }
}
