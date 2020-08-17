package com.cykj.marketadmin.webSocket;

public class ChatSaveAcc {
    private int id;
    private String chatAcc;
    private String chatUser;
    private String createTime;

    public ChatSaveAcc(int id, String chatAcc, String chatUser, String createTime) {
        this.id = id;
        this.chatAcc = chatAcc;
        this.chatUser = chatUser;
        this.createTime = createTime;
    }

    public ChatSaveAcc() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChatAcc() {
        return chatAcc;
    }

    public void setChatAcc(String chatAcc) {
        this.chatAcc = chatAcc;
    }

    public String getChatUser() {
        return chatUser;
    }

    public void setChatUser(String chatUser) {
        this.chatUser = chatUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
