package com.cykj.marketadmin.webSocket;

public class Msg<T> {

    private String chatAcc;
    private String charUser;
    private String chatOther;
    private String chatOtherAcc;
    private String msg;
    private String chatTime;
    private String room;


    public Msg() {
        super();
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getChatAcc() {
        return chatAcc;
    }

    public void setChatAcc(String chatAcc) {
        this.chatAcc = chatAcc;
    }

    public String getCharUser() {
        return charUser;
    }

    public void setCharUser(String charUser) {
        this.charUser = charUser;
    }

    public String getChatOther() {
        return chatOther;
    }

    public void setChatOther(String chatOther) {
        this.chatOther = chatOther;
    }

    public String getChatOtherAcc() {
        return chatOtherAcc;
    }

    public void setChatOtherAcc(String chatOtherAcc) {
        this.chatOtherAcc = chatOtherAcc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getChatTime() {
        return chatTime;
    }

    public void setChatTime(String chatTime) {
        this.chatTime = chatTime;
    }
}
