package com.orders.sir.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {

    private WebSocketHandler webSocketHandler;

    private WebSocketHandler alertWebSocketHandler;


    public SocketConfig(TextSocket textSocket, AlertSocket alertSocket) {
        this.webSocketHandler = textSocket;
        this.alertWebSocketHandler = alertSocket;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(webSocketHandler, "/ws/chat").setAllowedOrigins("*");
        registry.addHandler(alertWebSocketHandler, "/ws/alert").setAllowedOrigins("*");

    }


}

