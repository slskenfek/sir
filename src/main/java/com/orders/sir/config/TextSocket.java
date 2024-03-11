package com.orders.sir.config;


import com.orders.sir.event.socket.application.port.in.SocketPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;


@Component
@Log4j2
@RequiredArgsConstructor
public class TextSocket extends TextWebSocketHandler {

    private final SocketPort socketPort;


    private List<WebSocketSession> list = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payLoad = message.getPayload();
        log.info("session 값 : " + list);

        for (WebSocketSession webSocketSession : list) {
            webSocketSession.sendMessage(message);
        }

    }

    /**
     * 클라이언트 접속시
     *
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        list.add(session);
        log.info("세션 : " + session);
    }

    /**
     * client가 접속 해제시 호출되는 메소드
     *
     * @param session
     * @param status
     * @throws Exception
     */

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        list.remove(session);
    }
}
