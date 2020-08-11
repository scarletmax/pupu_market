package com.cykj.marketpojo;

public class Deliveryman {

    private int id;
    private String account;
    private String name;
    private String tel;
    private String idCard;
    private String sex;
    private int state;
    private String stateStr;
    private int autoOrderTaking;
    private Double money;
    private Double latitude;
    private Double longitude;
    private String pwd;

    public Deliveryman() {
    }

    public Deliveryman(int id, String account, String name, String tel, String idCard, String sex, int state, String stateStr, int autoOrderTaking, Double money, Double latitude, Double longitude, String pwd) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.tel = tel;
        this.idCard = idCard;
        this.sex = sex;
        this.state = state;
        this.stateStr = stateStr;
        this.autoOrderTaking = autoOrderTaking;
        this.money = money;
        this.latitude = latitude;
        this.longitude = longitude;
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public int getAutoOrderTaking() {
        return autoOrderTaking;
    }

    public void setAutoOrderTaking(int autoOrderTaking) {
        this.autoOrderTaking = autoOrderTaking;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
