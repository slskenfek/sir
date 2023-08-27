package com.orders.sir.event.application.port.out;

import com.orders.sir.event.domain.Socket;

import java.util.List;

public interface SocketLoadPort {

     List<Socket> socketHistoryList();
}
