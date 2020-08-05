package com.cykj.marketpojo;

import java.util.Date;

public class Shop {

    private int id;
    private  String name;
    private  String address;
    private String shopPic;
    private Double longitude;
    private  Double latitude;
    private String info;
    private String verifyID;
    private String verifyPic;
    private Date createTime;
    private String bossName;
    private String tel;
    private int state;
    private  String stateStr;
    private String code;//短信验证
    private String pwd;//密码

    public Shop() {
    }


    public Shop(int id, String name, String address, String shopPic, Double longitude, Double latitude, String info, String verifyID, String verifyPic, Date createTime, String bossName, String tel, int state, String stateStr, String code, String pwd) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.shopPic = shopPic;
        this.longitude = longitude;
        this.latitude = latitude;
        this.info = info;
        this.verifyID = verifyID;
        this.verifyPic = verifyPic;
        this.createTime = createTime;
        this.bossName = bossName;
        this.tel = tel;
        this.state = state;
        this.stateStr = stateStr;
        this.code = code;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopPic() {
        return shopPic;
    }

    public void setShopPic(String shopPic) {
        this.shopPic = shopPic;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getVerifyID() {
        return verifyID;
    }

    public void setVerifyID(String verifyID) {
        this.verifyID = verifyID;
    }

    public String getVerifyPic() {
        return verifyPic;
    }

    public void setVerifyPic(String verifyPic) {
        this.verifyPic = verifyPic;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", shopPic='" + shopPic + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", info='" + info + '\'' +
                ", verifyID='" + verifyID + '\'' +
                ", verifyPic='" + verifyPic + '\'' +
                ", createTime=" + createTime +
                ", bossName='" + bossName + '\'' +
                ", tel='" + tel + '\'' +
                ", state=" + state +
                ", stateStr='" + stateStr + '\'' +
                ", code=" + code +
                '}';
    }
}
