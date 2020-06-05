package com.xl.kffta.model;

import java.io.Serializable;

/**
 * @author created by zhanghaochen
 * @date 2020-06-05 14:57
 * 描述：上传地理位置信息
 */
public class LocationUploadBean implements Serializable {
    private String ObjectCodename;
    private long ObjectPagecode;
    private int ObjectID;
    private String PositionDateTime;
    private double Lat;
    private double Lng;
    private double Alt;

    public String getObjectCodename() {
        return ObjectCodename;
    }

    public void setObjectCodename(String objectCodename) {
        ObjectCodename = objectCodename;
    }

    public long getObjectPagecode() {
        return ObjectPagecode;
    }

    public void setObjectPagecode(long objectPagecode) {
        ObjectPagecode = objectPagecode;
    }

    public int getObjectID() {
        return ObjectID;
    }

    public void setObjectID(int objectID) {
        ObjectID = objectID;
    }

    public String getPositionDateTime() {
        return PositionDateTime;
    }

    public void setPositionDateTime(String positionDateTime) {
        PositionDateTime = positionDateTime;
    }

    public double getLat() {
        return Lat;
    }

    public void setLat(double lat) {
        Lat = lat;
    }

    public double getLng() {
        return Lng;
    }

    public void setLng(double lng) {
        Lng = lng;
    }

    public double getAlt() {
        return Alt;
    }

    public void setAlt(double alt) {
        Alt = alt;
    }
}
