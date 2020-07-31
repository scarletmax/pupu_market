package com.cykj.marketpojo;

import java.util.List;

public class AttrMsg {
    public List<Menu> attrList;
    public List<Menu> unAttrList;

    public AttrMsg() {
    }

    public AttrMsg(List<Menu> attrList, List<Menu> unAttrList) {
        this.attrList = attrList;
        this.unAttrList = unAttrList;
    }

    public List<Menu> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<Menu> attrList) {
        this.attrList = attrList;
    }

    public List<Menu> getUnAttrList() {
        return unAttrList;
    }

    public void setUnAttrList(List<Menu> unAttrList) {
        this.unAttrList = unAttrList;
    }
}
