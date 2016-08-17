
package com.example.mdarifur.tourmate.WeatherModel.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Hour {

    @SerializedName("time_epoch")
    @Expose
    private Integer timeEpoch;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("temp_c")
    @Expose
    private Double tempC;
    @SerializedName("temp_f")
    @Expose
    private Double tempF;
    @SerializedName("is_day")
    @Expose
    private Integer isDay;
    @SerializedName("condition")
    @Expose
    private Condition__ condition;
    @SerializedName("wind_mph")
    @Expose
    private Double windMph;
    @SerializedName("wind_kph")
    @Expose
    private Double windKph;
    @SerializedName("wind_degree")
    @Expose
    private Integer windDegree;
    @SerializedName("wind_dir")
    @Expose
    private String windDir;
    @SerializedName("pressure_mb")
    @Expose
    private Double pressureMb;
    @SerializedName("pressure_in")
    @Expose
    private Double pressureIn;
    @SerializedName("precip_mm")
    @Expose
    private Double precipMm;
    @SerializedName("precip_in")
    @Expose
    private Double precipIn;
    @SerializedName("humidity")
    @Expose
    private Integer humidity;
    @SerializedName("cloud")
    @Expose
    private Integer cloud;
    @SerializedName("feelslike_c")
    @Expose
    private Double feelslikeC;
    @SerializedName("feelslike_f")
    @Expose
    private Double feelslikeF;
    @SerializedName("windchill_c")
    @Expose
    private Double windchillC;
    @SerializedName("windchill_f")
    @Expose
    private Double windchillF;
    @SerializedName("heatindex_c")
    @Expose
    private Double heatindexC;
    @SerializedName("heatindex_f")
    @Expose
    private Double heatindexF;
    @SerializedName("dewpoint_c")
    @Expose
    private Double dewpointC;
    @SerializedName("dewpoint_f")
    @Expose
    private Double dewpointF;
    @SerializedName("will_it_rain")
    @Expose
    private Integer willItRain;
    @SerializedName("will_it_snow")
    @Expose
    private Integer willItSnow;

    /**
     * 
     * @return
     *     The timeEpoch
     */
    public Integer getTimeEpoch() {
        return timeEpoch;
    }

    /**
     * 
     * @param timeEpoch
     *     The time_epoch
     */
    public void setTimeEpoch(Integer timeEpoch) {
        this.timeEpoch = timeEpoch;
    }

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * 
     * @return
     *     The tempC
     */
    public Double getTempC() {
        return tempC;
    }

    /**
     * 
     * @param tempC
     *     The temp_c
     */
    public void setTempC(Double tempC) {
        this.tempC = tempC;
    }

    /**
     * 
     * @return
     *     The tempF
     */
    public Double getTempF() {
        return tempF;
    }

    /**
     * 
     * @param tempF
     *     The temp_f
     */
    public void setTempF(Double tempF) {
        this.tempF = tempF;
    }

    /**
     * 
     * @return
     *     The isDay
     */
    public Integer getIsDay() {
        return isDay;
    }

    /**
     * 
     * @param isDay
     *     The is_day
     */
    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    /**
     * 
     * @return
     *     The condition
     */
    public Condition__ getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition
     *     The condition
     */
    public void setCondition(Condition__ condition) {
        this.condition = condition;
    }

    /**
     * 
     * @return
     *     The windMph
     */
    public Double getWindMph() {
        return windMph;
    }

    /**
     * 
     * @param windMph
     *     The wind_mph
     */
    public void setWindMph(Double windMph) {
        this.windMph = windMph;
    }

    /**
     * 
     * @return
     *     The windKph
     */
    public Double getWindKph() {
        return windKph;
    }

    /**
     * 
     * @param windKph
     *     The wind_kph
     */
    public void setWindKph(Double windKph) {
        this.windKph = windKph;
    }

    /**
     * 
     * @return
     *     The windDegree
     */
    public Integer getWindDegree() {
        return windDegree;
    }

    /**
     * 
     * @param windDegree
     *     The wind_degree
     */
    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    /**
     * 
     * @return
     *     The windDir
     */
    public String getWindDir() {
        return windDir;
    }

    /**
     * 
     * @param windDir
     *     The wind_dir
     */
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    /**
     * 
     * @return
     *     The pressureMb
     */
    public Double getPressureMb() {
        return pressureMb;
    }

    /**
     * 
     * @param pressureMb
     *     The pressure_mb
     */
    public void setPressureMb(Double pressureMb) {
        this.pressureMb = pressureMb;
    }

    /**
     * 
     * @return
     *     The pressureIn
     */
    public Double getPressureIn() {
        return pressureIn;
    }

    /**
     * 
     * @param pressureIn
     *     The pressure_in
     */
    public void setPressureIn(Double pressureIn) {
        this.pressureIn = pressureIn;
    }

    /**
     * 
     * @return
     *     The precipMm
     */
    public Double getPrecipMm() {
        return precipMm;
    }

    /**
     * 
     * @param precipMm
     *     The precip_mm
     */
    public void setPrecipMm(Double precipMm) {
        this.precipMm = precipMm;
    }

    /**
     * 
     * @return
     *     The precipIn
     */
    public Double getPrecipIn() {
        return precipIn;
    }

    /**
     * 
     * @param precipIn
     *     The precip_in
     */
    public void setPrecipIn(Double precipIn) {
        this.precipIn = precipIn;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The cloud
     */
    public Integer getCloud() {
        return cloud;
    }

    /**
     * 
     * @param cloud
     *     The cloud
     */
    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    /**
     * 
     * @return
     *     The feelslikeC
     */
    public Double getFeelslikeC() {
        return feelslikeC;
    }

    /**
     * 
     * @param feelslikeC
     *     The feelslike_c
     */
    public void setFeelslikeC(Double feelslikeC) {
        this.feelslikeC = feelslikeC;
    }

    /**
     * 
     * @return
     *     The feelslikeF
     */
    public Double getFeelslikeF() {
        return feelslikeF;
    }

    /**
     * 
     * @param feelslikeF
     *     The feelslike_f
     */
    public void setFeelslikeF(Double feelslikeF) {
        this.feelslikeF = feelslikeF;
    }

    /**
     * 
     * @return
     *     The windchillC
     */
    public Double getWindchillC() {
        return windchillC;
    }

    /**
     * 
     * @param windchillC
     *     The windchill_c
     */
    public void setWindchillC(Double windchillC) {
        this.windchillC = windchillC;
    }

    /**
     * 
     * @return
     *     The windchillF
     */
    public Double getWindchillF() {
        return windchillF;
    }

    /**
     * 
     * @param windchillF
     *     The windchill_f
     */
    public void setWindchillF(Double windchillF) {
        this.windchillF = windchillF;
    }

    /**
     * 
     * @return
     *     The heatindexC
     */
    public Double getHeatindexC() {
        return heatindexC;
    }

    /**
     * 
     * @param heatindexC
     *     The heatindex_c
     */
    public void setHeatindexC(Double heatindexC) {
        this.heatindexC = heatindexC;
    }

    /**
     * 
     * @return
     *     The heatindexF
     */
    public Double getHeatindexF() {
        return heatindexF;
    }

    /**
     * 
     * @param heatindexF
     *     The heatindex_f
     */
    public void setHeatindexF(Double heatindexF) {
        this.heatindexF = heatindexF;
    }

    /**
     * 
     * @return
     *     The dewpointC
     */
    public Double getDewpointC() {
        return dewpointC;
    }

    /**
     * 
     * @param dewpointC
     *     The dewpoint_c
     */
    public void setDewpointC(Double dewpointC) {
        this.dewpointC = dewpointC;
    }

    /**
     * 
     * @return
     *     The dewpointF
     */
    public Double getDewpointF() {
        return dewpointF;
    }

    /**
     * 
     * @param dewpointF
     *     The dewpoint_f
     */
    public void setDewpointF(Double dewpointF) {
        this.dewpointF = dewpointF;
    }

    /**
     * 
     * @return
     *     The willItRain
     */
    public Integer getWillItRain() {
        return willItRain;
    }

    /**
     * 
     * @param willItRain
     *     The will_it_rain
     */
    public void setWillItRain(Integer willItRain) {
        this.willItRain = willItRain;
    }

    /**
     * 
     * @return
     *     The willItSnow
     */
    public Integer getWillItSnow() {
        return willItSnow;
    }

    /**
     * 
     * @param willItSnow
     *     The will_it_snow
     */
    public void setWillItSnow(Integer willItSnow) {
        this.willItSnow = willItSnow;
    }

}
