package com.orders.sir.event.socket.application.port.in;


import com.orders.sir.event.socket.domain.Socket;

import java.util.List;

public interface SocketPort {
    List<Socket> getHistoryList() throws Exception;

    void send();
}
