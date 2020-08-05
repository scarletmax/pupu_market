package com.cykj.marketpojo;

public class GoodsTypeRank {//商店物品分类排名

    private int value;
    private String name;

    public GoodsTypeRank() {
        super();
    }

    public GoodsTypeRank(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
