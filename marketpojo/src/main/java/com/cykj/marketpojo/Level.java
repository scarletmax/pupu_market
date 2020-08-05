package com.cykj.marketpojo;

public class Level {
    private int id;
    private String name;
    private int maxPoint;
    private int minPoint;

    public Level() {
    }

    public Level(int id, String name, int maxPoint, int minPoint) {
        this.id = id;
        this.name = name;
        this.maxPoint = maxPoint;
        this.minPoint = minPoint;
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

    public int getMaxPoint() {
        return maxPoint;
    }

    public void setMaxPoint(int maxPoint) {
        this.maxPoint = maxPoint;
    }

    public int getMinPoint() {
        return minPoint;
    }

    public void setMinPoint(int minPoint) {
        this.minPoint = minPoint;
    }
}
