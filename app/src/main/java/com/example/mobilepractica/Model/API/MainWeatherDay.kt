package com.example.mobilepractica.Model.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MainWeatherDay {
        @SerializedName("temp")
        @Expose
        var temp: Double? = null

        @SerializedName("description")
        @Expose
        var description : String?=null

        @SerializedName("icon")
        @Expose
        var icon : String?=null

}