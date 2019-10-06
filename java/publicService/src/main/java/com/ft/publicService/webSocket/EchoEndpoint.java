package com.ft.publicService.webSocket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
@ServerEndpoint("/echo")
@Component
public class EchoEndpoint{
    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            session.getBasicRemote().sendText(msg);
        } catch (IOException e) { }
    }

    @OnOpen
    public void open(Session session) {
        session.getUserProperties().put("previousMsg", " ");
    }
}
