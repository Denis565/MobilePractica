package com.example.mobilepractica.Model.APIExample

import com.example.mobilepractica.Model.API.MainWeatherDay
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MainExampleWeatherDay {
    @SerializedName("main")
    @Expose
    val mainWeather:MainWeatherDay.Main?=null

     @SerializedName("weather")
     @Expose
     val weather:List<MainWeatherDay.Weather>?=null

    @SerializedName("clouds")
    @Expose
    val clouds:MainWeatherDay.Clouds?=null

    @SerializedName("wind")
    @Expose
    val wind:MainWeatherDay.Wind?=null
}