
package com.example.mdarifur.tourmate.WeatherModel.forecast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Day {

    @SerializedName("maxtemp_c")
    @Expose
    private Double maxtempC;
    @SerializedName("maxtemp_f")
    @Expose
    private Double maxtempF;
    @SerializedName("mintemp_c")
    @Expose
    private Double mintempC;
    @SerializedName("mintemp_f")
    @Expose
    private Double mintempF;
    @SerializedName("avgtemp_c")
    @Expose
    private Double avgtempC;
    @SerializedName("avgtemp_f")
    @Expose
    private Double avgtempF;
    @SerializedName("maxwind_mph")
    @Expose
    private Double maxwindMph;
    @SerializedName("maxwind_kph")
    @Expose
    private Double maxwindKph;
    @SerializedName("totalprecip_mm")
    @Expose
    private Double totalprecipMm;
    @SerializedName("totalprecip_in")
    @Expose
    private Double totalprecipIn;
    @SerializedName("condition")
    @Expose
    private Condition_ condition;

    /**
     * 
     * @return
     *     The maxtempC
     */
    public Double getMaxtempC() {
        return maxtempC;
    }

    /**
     * 
     * @param maxtempC
     *     The maxtemp_c
     */
    public void setMaxtempC(Double maxtempC) {
        this.maxtempC = maxtempC;
    }

    /**
     * 
     * @return
     *     The maxtempF
     */
    public Double getMaxtempF() {
        return maxtempF;
    }

    /**
     * 
     * @param maxtempF
     *     The maxtemp_f
     */
    public void setMaxtempF(Double maxtempF) {
        this.maxtempF = maxtempF;
    }

    /**
     * 
     * @return
     *     The mintempC
     */
    public Double getMintempC() {
        return mintempC;
    }

    /**
     * 
     * @param mintempC
     *     The mintemp_c
     */
    public void setMintempC(Double mintempC) {
        this.mintempC = mintempC;
    }

    /**
     * 
     * @return
     *     The mintempF
     */
    public Double getMintempF() {
        return mintempF;
    }

    /**
     * 
     * @param mintempF
     *     The mintemp_f
     */
    public void setMintempF(Double mintempF) {
        this.mintempF = mintempF;
    }

    /**
     * 
     * @return
     *     The avgtempC
     */
    public Double getAvgtempC() {
        return avgtempC;
    }

    /**
     * 
     * @param avgtempC
     *     The avgtemp_c
     */
    public void setAvgtempC(Double avgtempC) {
        this.avgtempC = avgtempC;
    }

    /**
     * 
     * @return
     *     The avgtempF
     */
    public Double getAvgtempF() {
        return avgtempF;
    }

    /**
     * 
     * @param avgtempF
     *     The avgtemp_f
     */
    public void setAvgtempF(Double avgtempF) {
        this.avgtempF = avgtempF;
    }

    /**
     * 
     * @return
     *     The maxwindMph
     */
    public Double getMaxwindMph() {
        return maxwindMph;
    }

    /**
     * 
     * @param maxwindMph
     *     The maxwind_mph
     */
    public void setMaxwindMph(Double maxwindMph) {
        this.maxwindMph = maxwindMph;
    }

    /**
     * 
     * @return
     *     The maxwindKph
     */
    public Double getMaxwindKph() {
        return maxwindKph;
    }

    /**
     * 
     * @param maxwindKph
     *     The maxwind_kph
     */
    public void setMaxwindKph(Double maxwindKph) {
        this.maxwindKph = maxwindKph;
    }

    /**
     * 
     * @return
     *     The totalprecipMm
     */
    public Double getTotalprecipMm() {
        return totalprecipMm;
    }

    /**
     * 
     * @param totalprecipMm
     *     The totalprecip_mm
     */
    public void setTotalprecipMm(Double totalprecipMm) {
        this.totalprecipMm = totalprecipMm;
    }

    /**
     * 
     * @return
     *     The totalprecipIn
     */
    public Double getTotalprecipIn() {
        return totalprecipIn;
    }

    /**
     * 
     * @param totalprecipIn
     *     The totalprecip_in
     */
    public void setTotalprecipIn(Double totalprecipIn) {
        this.totalprecipIn = totalprecipIn;
    }

    /**
     * 
     * @return
     *     The condition
     */
    public Condition_ getCondition() {
        return condition;
    }

    /**
     * 
     * @param condition
     *     The condition
     */
    public void setCondition(Condition_ condition) {
        this.condition = condition;
    }

}
