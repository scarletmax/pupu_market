package com.cykj.marketpojo;

import java.util.Date;

public class User {
    private int id;
    private  String account;
    private String name;
    private String pwd;
    private String iconUrl;
    private int levelId;
    private String levelName;
    private int point;
    private int state;
    private  String stateStr;
    private Date regTime;
    private String openId;

    public User() {
    }

    public User(String name, String iconUrl, String openId) {
        this.name = name;
        this.iconUrl = iconUrl;
        this.openId = openId;
    }

    public User(int id, String account, String name, String pwd, String iconUrl, int levelId, String levelName, int point, int state, String stateStr, Date regTime) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.pwd = pwd;
        this.iconUrl = iconUrl;
        this.levelId = levelId;
        this.levelName = levelName;
        this.point = point;
        this.state = state;
        this.stateStr = stateStr;
        this.regTime = regTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
