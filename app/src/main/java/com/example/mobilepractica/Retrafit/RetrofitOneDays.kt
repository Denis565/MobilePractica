package com.example.mobilepractica.Retrafit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitOneDays {

    fun getClient(baseUrl: String):Retrofit{

        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit

    }

}