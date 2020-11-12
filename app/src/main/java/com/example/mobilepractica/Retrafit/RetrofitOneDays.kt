package com.example.mobilepractica.Retrafit

import com.example.mobilepractica.BuildConfig
import com.example.mobilepractica.ClassConstant
import com.example.mobilepractica.Interface.WeatherAPIInterface
import com.example.mobilepractica.Model.APIExample.MainExampleWeatherDay
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitOneDays {

    fun getClient(title:String):Call<MainExampleWeatherDay>{

        val retrofit = Retrofit.Builder()
                .baseUrl(ClassConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val apiInterfaceInterface: WeatherAPIInterface =retrofit.create(WeatherAPIInterface::class.java)

        val call:Call<MainExampleWeatherDay> = apiInterfaceInterface.getWeather(title,"metric","ru", BuildConfig.OPEN_WEATHER_MAP_API_KEY)

        return call

    }

}