package com.cykj.marketpojo;


import java.util.ArrayList;
import java.util.List;

public class Menu {
    private Integer id;
    private String name;
    private String url;
    private String iconUrl;
    private Integer parentId;
    private Integer orders;
    private List<Menu> childList;
    private Integer roleId;
    private ArrayList<String> list;


    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public Menu() {
    }

    public Menu(Integer id, String name, String url, Integer parentId, Integer orders, List<Menu> childList, Integer roleId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.parentId = parentId;
        this.orders = orders;
        this.childList = childList;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}

