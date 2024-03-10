package com.orders.sir.event.socket.adapter.out.persistence;

import com.orders.sir.event.socket.application.port.out.SocketLoadPort;
import com.orders.sir.event.socket.domain.Socket;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SocketPersistenceAdapter implements SocketLoadPort {

    @Override
    public List<Socket> socketHistoryList() {
        return null;
    }
}
