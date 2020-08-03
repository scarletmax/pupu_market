package com.cykj.marketpojo;

import java.math.BigDecimal;

public class DataAnalysis {
    private String name;
    private BigDecimal record;
    private int num;

    public DataAnalysis() {
    }

    public DataAnalysis(String name, BigDecimal record) {
        this.name = name;
        this.record = record;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRecord() {
        return record;
    }

    public void setRecord(BigDecimal record) {
        this.record = record;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
