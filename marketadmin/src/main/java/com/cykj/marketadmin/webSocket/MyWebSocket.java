package com.cykj.marketadmin.webSocket;

import com.alibaba.fastjson.JSON;
import com.cykj.marketadmin.service.ChatService;
import com.cykj.marketadmin.service.ChatWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint(value = "/websocket/{user}/{userId}")
@Component
public class MyWebSocket {
    // 通过类似GET请求方式传递参数的方法（服务端采用第二种方法"WebSocketHandler"实现）
//    websocket = new WebSocket("ws://127.0.0.1:18080/testWebsocket?id=23&name=Lebron");
    /**
     * 在线人数
     */
    public static AtomicInteger onlineNumber = new AtomicInteger(0);

    /**
     * 所有的对象，每次连接建立，都会将我们自己定义的MyWebSocket存放到List中，
     */
    public static List<MyWebSocket> webSockets = new CopyOnWriteArrayList<MyWebSocket>();

    /**
     * 会话，与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    /**
     * 每个会话的用户
     */
    private String user;
    //    private String other;
    private String userId;

//    解决webSocket在spring项目中无法注入bean问题

    private static ChatWebService chatWebService;
    @Autowired
    public void setChatService(ChatWebService chatWebService) {
        MyWebSocket.chatWebService = chatWebService;
    }


    /**
     * 建立连接
     *
     * @param session
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("user") String user, @PathParam("userId") String userId) {
        if (user == null || "".equals(user)) {
            try {
                session.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        onlineNumber.incrementAndGet();
        for (MyWebSocket myWebSocket : webSockets) {
            if (user.equals(myWebSocket.user)) {
                try {
                    session.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return;
            }
        }

        this.session = session;
        this.user = user;
        this.userId = userId;
        webSockets.add(this);
        System.out.println("有新连接加入！ 当前在线人数" + onlineNumber.get());
    }

    /**
     * 连接关闭
     */
    @OnClose
    public void onClose() {
        onlineNumber.decrementAndGet();
        webSockets.remove(this);

        System.out.println("有连接关闭！ 当前在线人数" + onlineNumber.get());
    }

    /**
     * 收到客户端的消息
     *
     * @param message 消息
     * @param session 会话
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("user") String user, @PathParam("other") String other, @PathParam("userId") String userId, @PathParam("otherId") String otherId) {
        System.out.println("来自" + user + "消息：" + message );
        String chatUser = null;
        String chatAcc = null;
        String msg = null;
        if (message != null && !message.equals("")) {
            String[] str = message.split("=:");

            if (str.length > 1) {
                chatUser = str[0];
                chatAcc = str[1];
                msg = str[2];
                System.out.println("聊天对象=" + chatAcc);
                Msg msg2 = new Msg();
                msg2.setMsg(msg);
                msg2.setCharUser(user);
                msg2.setChatAcc(userId);
                msg2.setChatOther(chatUser);
                msg2.setChatOtherAcc(chatAcc);

                chatWebService.insertChatMsg(msg2);
            }
        }

        pushMessage(user, msg, chatUser, userId, chatAcc);
    }

    /**
     * 发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) {
        try {

            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 消息推送
     *
     * @param message
     * @param otherId uuid为空则推送全部人员
     */
    public static void pushMessage(String user, String message, String other, String userId, String otherId) {

        Msg msg = new Msg();
        msg.setMsg(message);
        msg.setCharUser(user);
        msg.setChatAcc(userId);
        msg.setChatOther(other);
        msg.setChatOtherAcc(otherId);


        if (otherId == null || "".equals(otherId)) {

//            for (MyWebSocket myWebSocket : webSockets) {//群聊
//
//                myWebSocket.sendMessage(JSON.toJSONString(msg));
//            }
        } else {
            int a=0;
            for (MyWebSocket myWebSocket : webSockets) {

                    if (otherId.equals(myWebSocket.userId)) {//一对一聊天
//                    myWebSocket.sendMessage(message);

                        myWebSocket.sendMessage(JSON.toJSONString(msg));

                        break;
                    }
                a++;
            }
            if(a==onlineNumber.get()){
                for (MyWebSocket myWebSocket : webSockets) {
                    if (userId.equals(myWebSocket.userId)) {//一对一聊天
                        msg.setMsg("---系统回复,对方不在线---");
                        System.out.println("发回自己");
                        myWebSocket.sendMessage(JSON.toJSONString(msg));
                        break;
                    }
                }
            }
        }

    }
}