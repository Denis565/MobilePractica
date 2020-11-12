package com.example.mobilepractica.Model.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MainWeatherDay {
        class Main {
                @SerializedName("temp")
                @Expose
                var temp: Double? = null

                @SerializedName("pressure")
                @Expose
                var pressure: Int? = null

                @SerializedName("humidity")
                @Expose
                var humidity: Int? = null
        }

        class Weather {
                @SerializedName("description")
                @Expose
                var description: String? = null
        }

        class Clouds{
                @SerializedName("all")
                @Expose
                var all: Int? = null
        }

        class Wind{
                @SerializedName("speed")
                @Expose
                var speed : Int?=null
        }
}