package com.item.tracker.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LatLong {
    private String latitude;
    private String longitude;
    private String coordStd;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCoordStd() {
        return coordStd;
    }

    public void setCoordStd(String coordStd) {
        this.coordStd = coordStd;
    }

    @Override
    public String toString() {
        return "LatLong{" +
                "latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", coordStd='" + coordStd + '\'' +
                '}';
    }
}
