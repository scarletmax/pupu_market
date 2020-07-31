package com.cykj.marketpojo;

public class Point {
    private int id;
    private int pointNum;
    private int  userId;
    private int state;
    private String userName;
    private  String stateStr;

    public Point() {
    }

    public Point(int id, int pointNum, int userId, int state, String userName, String stateStr) {
        this.id = id;
        this.pointNum = pointNum;
        this.userId = userId;
        this.state = state;
        this.userName = userName;
        this.stateStr = stateStr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPointNum() {
        return pointNum;
    }

    public void setPointNum(int pointNum) {
        this.pointNum = pointNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }
}
