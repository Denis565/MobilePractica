package com.example.mobilepractica.Interface

import com.example.mobilepractica.Model.APIExample.MainExampleWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAPIInterface{

   // val url="https://api.openweathermap.org/data/2.5/onecall?lat=33.441792&lon=-94.037689
   // &exclude=current,minutely,hourly,alerts&appid=401e7c441a859bf21e718863f6bbc7ab&lang=ru"
    @GET("weather")
    fun getWeather(
        @Query("q") city: String,
        @Query("units") units:String,
        @Query("lang") lang:String,
        @Query("appid") api_key: String
    ): Call<MainExampleWeather>

    @GET("onecall")
    fun weatherSevenDays(
        @Query("lat") lat: Double,
        @Query("lon") lon:Double,
        @Query("units") units:String,
        @Query("exclude") exclude:String,
        @Query("appid") api_key: String
    ):Call<MainExampleWeather>

}


