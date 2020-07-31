package com.cykj.marketpojo;

public class Admin {
    private int id;
    private String account;
    private String name;
    private String pwd;
    private int state;
    private String stateText;
    private int roleId;
    private String roleName;
    private String tel;

    public Admin() {
    }

    public Admin(int id, String account, String name, String pwd, int state, String stateText, int roleId, String roleName, String tel) {
        this.id = id;
        this.account = account;
        this.name = name;
        this.pwd = pwd;
        this.state = state;
        this.stateText = stateText;
        this.roleId = roleId;
        this.roleName = roleName;
        this.tel = tel;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateText() {
        return stateText;
    }

    public void setStateText(String stateText) {
        this.stateText = stateText;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
