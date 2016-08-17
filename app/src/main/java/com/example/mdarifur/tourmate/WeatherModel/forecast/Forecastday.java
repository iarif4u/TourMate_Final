
package com.example.mdarifur.tourmate.WeatherModel.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Forecastday {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("date_epoch")
    @Expose
    private Integer dateEpoch;
    @SerializedName("day")
    @Expose
    private Day day;
    @SerializedName("astro")
    @Expose
    private Astro astro;
    @SerializedName("hour")
    @Expose
    private List<Hour> hour = new ArrayList<Hour>();

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The dateEpoch
     */
    public Integer getDateEpoch() {
        return dateEpoch;
    }

    /**
     * 
     * @param dateEpoch
     *     The date_epoch
     */
    public void setDateEpoch(Integer dateEpoch) {
        this.dateEpoch = dateEpoch;
    }

    /**
     * 
     * @return
     *     The day
     */
    public Day getDay() {
        return day;
    }

    /**
     * 
     * @param day
     *     The day
     */
    public void setDay(Day day) {
        this.day = day;
    }

    /**
     * 
     * @return
     *     The astro
     */
    public Astro getAstro() {
        return astro;
    }

    /**
     * 
     * @param astro
     *     The astro
     */
    public void setAstro(Astro astro) {
        this.astro = astro;
    }

    /**
     * 
     * @return
     *     The hour
     */
    public List<Hour> getHour() {
        return hour;
    }

    /**
     * 
     * @param hour
     *     The hour
     */
    public void setHour(List<Hour> hour) {
        this.hour = hour;
    }

}
