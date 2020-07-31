package com.cykj.marketpojo;

import java.util.Date;

public class ShopAdmin {
    private int id;
    private String account;
    private String name;
    private String pwd;
    private int shopId;
    private String shopName;
    private String tel;
    private Date createTime;

    public ShopAdmin() {
    }

    public ShopAdmin(int id, String account, String name, String pwd, int shopId, String tel, Date createTime) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.pwd = pwd;
        this.shopId = shopId;
        this.tel = tel;
        this.createTime = createTime;
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

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
