package com.orders.sir.event.application.port.out;

import com.orders.sir.event.domain.Team;

import java.util.List;

public interface TeamLoadPort {

    List<Team> getTeamList();
}
