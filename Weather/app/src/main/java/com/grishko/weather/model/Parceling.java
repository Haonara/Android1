package com.grishko.weather.model;

import java.io.Serializable;

public class Parceling implements Serializable{
    private String city_name;
    private boolean visibilityWet;
    private boolean visibilityWind;

    public Parceling(String city_name, boolean visibilityWet, boolean visibilityWind) {
        this.city_name = city_name;
        this.visibilityWet = visibilityWet;
        this.visibilityWind = visibilityWind;
    }

    public String getCity_name() {
        return city_name;
    }

    public boolean isVisibilityWet() {
        return visibilityWet;
    }

    public boolean isVisibilityWind() {
        return visibilityWind;
    }

}
