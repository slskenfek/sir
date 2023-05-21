package com.orders.sir.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberActionService implements Action{

    private final ActionPersistence actionPersistence;

    @Override
    public <T> void saveActionId(T type) {

    }
}
