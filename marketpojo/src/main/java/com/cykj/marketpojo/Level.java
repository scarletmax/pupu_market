package com.cykj.marketpojo;

public class Level {
    private int id;
    private String name;
    private int max_point;
    private int min_point;

    public Level() {
    }

    public Level(int id, String name, int max_point, int min_point) {
        this.id = id;
        this.name = name;
        this.max_point = max_point;
        this.min_point = min_point;
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

    public int getMax_point() {
        return max_point;
    }

    public void setMax_point(int max_point) {
        this.max_point = max_point;
    }

    public int getMin_point() {
        return min_point;
    }

    public void setMin_point(int min_point) {
        this.min_point = min_point;
    }
}
