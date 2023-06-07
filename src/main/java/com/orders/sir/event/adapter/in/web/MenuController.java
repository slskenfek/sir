package com.orders.sir.event.adapter.in.web;

import com.orders.sir.event.application.port.in.MenuUserCasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MenuController {
    private final MenuUserCasePort menuUserCasePort;

    public void createMenu() {
        menuUserCasePort.createMenu();
        ResponseEntity.ok().body("success");
    }


}
