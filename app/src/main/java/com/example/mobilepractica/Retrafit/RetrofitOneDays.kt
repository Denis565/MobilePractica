package com.example.mobilepractica.Retrafit

import com.example.mobilepractica.BuildConfig
import com.example.mobilepractica.ClassConstant
import com.example.mobilepractica.Interface.WeatherAPIInterface
import com.example.mobilepractica.Model.APIExample.MainExampleWeather
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitOneDays {

    fun getClient():Retrofit{

        val retrofit = Retrofit.Builder()
                .baseUrl(ClassConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit

    }

}