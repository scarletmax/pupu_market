package com.cykj.marketpojo;

public class Type {

    private int id;
    private String name;
    private String parentId;
    private String iconUrl;


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
}
