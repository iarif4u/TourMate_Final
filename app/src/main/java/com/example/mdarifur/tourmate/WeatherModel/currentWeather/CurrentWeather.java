
package com.example.mdarifur.tourmate.WeatherModel.currentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class CurrentWeather {

    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("current")
    @Expose
    private Current current;

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The current
     */
    public Current getCurrent() {
        return current;
    }

    /**
     * 
     * @param current
     *     The current
     */
    public void setCurrent(Current current) {
        this.current = current;
    }

}
