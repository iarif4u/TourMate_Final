package com.example.mdarifur.tourmate.Interface;


import com.example.mdarifur.tourmate.WeatherModel.currentWeather.CurrentWeather;
import com.example.mdarifur.tourmate.WeatherModel.forecast.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;


/**
 * Created by MD.Arifur on 8/12/2016.
 */
public interface API_Interface {

    @GET
    Call<CurrentWeather> getCurrentWeather(@Url String url);


    @GET
    Call<Forecast> getForecastWeather(@Url String url);
}
