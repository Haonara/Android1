package com.grishko.weather.model;

import java.io.Serializable;

public class Parceling implements Serializable{
    private String city_name;
    private boolean visibilityWet;
    private boolean visibilityWind;

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public boolean isVisibilityWet() {
        return visibilityWet;
    }

    public void setVisibilityWet(boolean visibilityWet) {
        this.visibilityWet = visibilityWet;
    }

    public boolean isVisibilityWind() {
        return visibilityWind;
    }

    public void setVisibilityWind(boolean visibilityWind) {
        this.visibilityWind = visibilityWind;
    }

}
