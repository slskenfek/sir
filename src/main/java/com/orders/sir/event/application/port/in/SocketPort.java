package com.orders.sir.event.application.port.in;


import com.orders.sir.event.domain.Socket;

import java.util.List;

public interface SocketPort {
    List<Socket> getHistoryList() throws Exception;

    void send();
}
