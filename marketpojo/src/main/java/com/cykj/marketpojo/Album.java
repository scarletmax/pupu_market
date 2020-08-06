package com.cykj.marketpojo;

import java.util.List;

public class Album {

    private String title;//相册标题
    private int id;//相册id
    private int start;//起始图片id,默认0
    private Photo[] data;//该相册包含的图片

    public Album() {
    }

    public Album(String title, int id, int start, com.cykj.marketpojo.Photo[] data) {
        this.title = title;
        this.id = id;
        this.start = start;
        this.data = data;
    }


    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public int getStart() {
        return start;
    }

    public com.cykj.marketpojo.Photo[] getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setData(com.cykj.marketpojo.Photo[] data) {
        this.data = data;
    }
}
