package com.orders.sir.event.team.application.port.out;

import com.orders.sir.event.team.domain.Team;

import java.util.List;

public interface TeamLoadPort {

    List<Team> getTeamList();
}
