package com.cykj.marketpojo;

import java.util.List;

public class DeliverMsg {
    private  String origin;
    private String destination;
    private String waypoints;
    private double oriLongitude;
    private double oriLatitude;
    private double desLongitude;
    private double desLatitude;
    private double wayLongitude;
    private double wayLatitude;
    private List<Marker> markers;
    private String benefit;
    private String arriveHour;
    private String arriveDate;
    private String orderNum;
    private String tel;

    public DeliverMsg() {
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOrigin() {
        return origin;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public String getArriveHour() {
        return arriveHour;
    }

    public void setArriveHour(String arriveHour) {
        this.arriveHour = arriveHour;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getWaypoints() {
        return waypoints;
    }

    public void setWaypoints(String waypoints) {
        this.waypoints = waypoints;
    }

    public double getOriLongitude() {
        return oriLongitude;
    }

    public void setOriLongitude(double oriLongitude) {
        this.oriLongitude = oriLongitude;
    }

    public double getOriLatitude() {
        return oriLatitude;
    }

    public void setOriLatitude(double oriLatitude) {
        this.oriLatitude = oriLatitude;
    }

    public double getDesLongitude() {
        return desLongitude;
    }

    public void setDesLongitude(double desLongitude) {
        this.desLongitude = desLongitude;
    }

    public double getDesLatitude() {
        return desLatitude;
    }

    public void setDesLatitude(double desLatitude) {
        this.desLatitude = desLatitude;
    }

    public double getWayLongitude() {
        return wayLongitude;
    }

    public void setWayLongitude(double wayLongitude) {
        this.wayLongitude = wayLongitude;
    }

    public double getWayLatitude() {
        return wayLatitude;
    }

    public void setWayLatitude(double wayLatitude) {
        this.wayLatitude = wayLatitude;
    }

    public List<Marker> getMarkers() {
        return markers;
    }

    public void setMarkers(List<Marker> markers) {
        this.markers = markers;
    }
}
