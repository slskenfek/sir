package com.orders.sir.config;

import com.orders.sir.event.application.port.in.MemberUseCasePort;
import com.orders.sir.event.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
@Log4j2
public class AlertSocket extends TextWebSocketHandler {

    private final MemberUseCasePort memberUseCasePort;

    private List<WebSocketSession> list = new ArrayList<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        List<Member> memberList =
                memberUseCasePort.findMemberList();

        if(memberList.size() != 0) {
       for(WebSocketSession webSocketSession : list) {

            for (Member member : memberList) {
                webSocketSession.sendMessage(new TextMessage(member.getMemberName()));
            }

         }
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
