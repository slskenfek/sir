package com.orders.sir.event.adapter.in.web;


import com.orders.sir.event.application.port.in.TeamUsePort;
import com.orders.sir.event.domain.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamUsePort teamUsePort;

        @GetMapping("")
        public ResponseEntity<List<Team>> getTeamLst() {
            List<Team> teamList = teamUsePort.getTeamList();
            return ResponseEntity.ok().body(teamList);
        }

}
