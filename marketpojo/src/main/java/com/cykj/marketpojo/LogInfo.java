package com.cykj.marketpojo;

import java.util.Date;

public class LogInfo {
    private int id;
    private int adminId;
    private String operator;
    private Date occurTime;
    private String type;
    private String opr;


    public LogInfo() {
    }


    public LogInfo(String operator, String type, String opr) {
        this.operator = operator;
        this.type = type;
        this.opr = opr;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Date getOccurTime() {
        return occurTime;
    }

    public void setOccurTime(Date occurTime) {
        this.occurTime = occurTime;
    }

    public String getOpr() {
        return opr;
    }

    public void setOpr(String opr) {
        this.opr = opr;
    }
}
