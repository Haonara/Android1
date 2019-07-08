package com.grishko.weather.model;

import java.io.Serializable;

public class Parcel implements Serializable{
    private String city_name;
    private String visibilityWet;
    private String visibilityWind;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getVisibilityWet() {
        return visibilityWet;
    }

    public void setVisibilityWet(String visibilityWet) {
        this.visibilityWet = visibilityWet;
    }

    public String getVisibilityWind() {
        return visibilityWind;
    }

    public void setVisibilityWind(String visibilityWind) {
        this.visibilityWind = visibilityWind;
    }
}
