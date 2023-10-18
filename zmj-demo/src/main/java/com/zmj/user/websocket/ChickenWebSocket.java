package com.zmj.user.websocket;

import com.zmj.websocket.config.WebSocketServerConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZMJ
 * @Package com.zmj.user.websocket
 * @date 2023/10/17 21:32
 */

@Slf4j
@Component
@ServerEndpoint(value = "/chicken/socket", configurator = WebSocketServerConfig.class)
public class ChickenWebSocket {

    /**
     * 记录当前在线的连接数
     */
    private static AtomicInteger onlineCount = new AtomicInteger(0);


    /**
     * 存放所有的在线客户端
     */
    private static Map<String, ChickenWebSocket> clients = new ConcurrentHashMap<>();


    /**
     * 客户端连接的session会话
     */
    private Session session;

    /**
     * 标识当前会话的key(唯一)
     */
    private String erp = "";

    @OnOpen
    public void onOpen(Session session, EndpointConfig endpointConfig) throws Exception {
        Map<String, Object> userProperties = endpointConfig.getUserProperties();
        String erp = (String) userProperties.get("erp");

        this.erp = erp;
        this.session = session;

        if (clients.containsKey(this.erp)){
            clients.get(this.erp).session.close();
            clients.remove(this.erp);
            onlineCount.decrementAndGet();
        }
        clients.put(this.erp,this);
        onlineCount.incrementAndGet();
        log.info("有新连接加入：[{}]，当前在线人数：{}",erp,onlineCount.get());
        sendMessage("连接成功",session);
    }

    @OnClose
    public void onClose() throws IOException {
        if (clients.containsKey(this.erp)){
            clients.get(erp).session.close();
            clients.remove(erp);
            onlineCount.decrementAndGet();
        }
        log.info("有一处连接关闭[{}]，当前在线人数：{}",this.erp,onlineCount.get());
    }


    @OnError
    public void onError(Session session,Throwable throwable) throws IOException {
        log.error("websocket:{}，发送信息{}",this.erp,throwable.getMessage(),throwable);
        session.close();
    }

    @OnMessage
    public void onMessage(String message,Session session) throws Exception {
        log.info("服务端收到客户端[{}]的消息：{}",this.erp,message);
        //心跳机制
        if (message.equals("ping")){
            this.sendMessage("pong",session);
        }
    }

    /**
     * 指定发送消息
     */
    public void sendMessage(String message,Session session)throws Exception{
        log.info("服务端给客户端{}发送消息{}",this.erp,message);
        session.getBasicRemote().sendText(message);
    }

    /**
     * 群发消息
     */
    public void sendMessage(String message)throws Exception{
        for (Map.Entry<String, ChickenWebSocket> sessionEntry : clients.entrySet()) {
            String erp = sessionEntry.getKey();
            ChickenWebSocket socket;
            socket = sessionEntry.getValue();
            Session session = socket.session;
            log.info("服务端给客户端[{}]发送消息{}", erp, message);
            try {
                session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                log.error("{}发送消息发生异常，异常原因{}", this.erp, message);
            }
        }
    }

}

