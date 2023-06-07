package com.orders.sir.event.application.service;

import com.orders.sir.event.application.port.in.MenuUserCasePort;
import com.orders.sir.event.application.port.out.MemberLoadPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MenuService implements MenuUserCasePort {

    private final MemberLoadPort memberLoadPort;

    @Override
    public void createMenu() {

    }
}
