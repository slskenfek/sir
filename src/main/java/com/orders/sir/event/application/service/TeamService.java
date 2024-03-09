package com.orders.sir.event.application.service;

import com.orders.sir.event.adapter.out.persistence.team.TeamPersitenceAdapter;
import com.orders.sir.event.application.port.in.TeamUsePort;
import com.orders.sir.event.domain.Team;
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
