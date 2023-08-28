package com.orders.sir.config;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Component
@Log4j2
public class AlertSocket extends TextWebSocketHandler {

    private List<WebSocketSession> list = new ArrayList<>();


    public void sendNotication(String msg) throws IOException {
        for(WebSocketSession webSocketSession : list) {
            webSocketSession.sendMessage(new TextMessage(msg));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
      list.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
       list.remove(session);
    }
}
