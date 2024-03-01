package com.orders.sir.event.application.port.in;

import com.orders.sir.event.domain.Team;

import java.util.List;

public interface TeamUsePort {

    List<Team> getTeamList();
}
