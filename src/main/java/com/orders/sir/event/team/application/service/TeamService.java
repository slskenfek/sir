package com.orders.sir.event.team.application.service;

import com.orders.sir.event.team.adapter.out.persistence.TeamPersitenceAdapter;
import com.orders.sir.event.team.application.port.in.TeamUsePort;
import com.orders.sir.event.team.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class TeamService implements TeamUsePort {

    private final TeamPersitenceAdapter teamPersitenceAdapter;


    @Override
    public List<Team> getTeamList() {
        return teamPersitenceAdapter.getTeamList();
    }
}
