package com.cykj.marketpojo;

public class Photo {

    private String alt; //图片名
    private int pid;//图片id
    private String src;//url
    private String thumb;//缩略图url

    public Photo() {
    }

    public Photo(String alt, int pid, String src, String thumb) {
        this.alt = alt;
        this.pid = pid;
        this.src = src;
        this.thumb = thumb;
    }

    public String getAlt() {
        return alt;
    }

    public int getPid() {
        return pid;
    }

    public String getSrc() {
        return src;
    }

    public String getThumb() {
        return thumb;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
}
