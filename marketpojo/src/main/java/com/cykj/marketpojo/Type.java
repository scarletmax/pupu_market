package com.cykj.marketpojo;

public class Type {

    private int id;
    private String name;
    private String parentId;
    private String iconUrl;
    private int state;
    private String stateStr;


    public Type() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getParentId() {
        return parentId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public int getState() {
        return state;
    }

    public String getStateStr() {
        return stateStr;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setStateStr(String stateStr) {
        this.stateStr = stateStr;
    }
}
