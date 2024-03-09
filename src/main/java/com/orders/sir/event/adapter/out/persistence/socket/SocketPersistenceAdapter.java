package com.orders.sir.event.adapter.out.persistence.socket;

import com.orders.sir.event.application.port.out.SocketLoadPort;
import com.orders.sir.event.domain.Socket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SocketPersistenceAdapter implements SocketLoadPort {

    @Override
    public List<Socket> socketHistoryList() {
        return null;
    }
}
