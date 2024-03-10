package com.orders.sir.event.team.application.port.in;

import com.orders.sir.event.team.domain.Team;

import java.util.List;

public interface TeamUsePort {

    List<Team> getTeamList();
}
