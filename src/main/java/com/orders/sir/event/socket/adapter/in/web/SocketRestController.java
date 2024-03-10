package com.orders.sir.event.socket.adapter.in.web;

import com.orders.sir.event.socket.application.port.in.SocketPort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/socket/api/v1")
@RequiredArgsConstructor
public class SocketRestController {

    private final SocketPort socketPort;

    @PostMapping("/send")
    public void sendMsg() {
        socketPort.send();
    }

}
