package com.orders.sir.event.application.service;

import com.orders.sir.event.application.port.in.SocketPort;
import com.orders.sir.event.application.port.out.SocketLoadPort;
import com.orders.sir.event.domain.Socket;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocketService implements SocketPort  {

    private final SocketLoadPort socketLoadPort;

    @Override
    public List<Socket> getHistoryList() throws NullPointerException {
        Socket socket = new Socket();
        List<Socket> history = socketLoadPort.socketHistoryList();


        return null;
    }

    @Override
    public void send() {

    }
}
