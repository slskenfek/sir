package com.orders.sir.event.adapter.in.web;

import com.orders.sir.event.application.port.in.MovieUserCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
public class MovieController {
    private final MovieUserCasePort movieUserCasePort;

    public void views() {
        movieUserCasePort.views();
        ResponseEntity.ok().body("success");


    }


}
