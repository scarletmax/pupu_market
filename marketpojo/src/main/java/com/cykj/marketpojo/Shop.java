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
    private Date creatTime;
    private String bossName;
    private String tel;

    public Shop() {
    }

    public Shop(int id, String name, String address, String shopPic, Double longitude, Double latitude, String info, String verifyID, String verifyPic, Date creatTime, String bossName, String tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.shopPic = shopPic;
        this.longitude = longitude;
        this.latitude = latitude;
        this.info = info;
        this.verifyID = verifyID;
        this.verifyPic = verifyPic;
        this.creatTime = creatTime;
        this.bossName = bossName;
        this.tel = tel;
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

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
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
}
