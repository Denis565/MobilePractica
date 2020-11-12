package com.example.mobilepractica.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobilepractica.ClassConstant
import com.example.mobilepractica.Model.APIExample.MainExampleWeatherDay
import com.example.mobilepractica.R
import com.example.mobilepractica.Retrafit.RetrofitOneDays
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("DEPRECATION")
class WeatherFragment : Fragment() {

    lateinit var sharedPreferences:android.content.SharedPreferences
    lateinit var urlImage:String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(activity)

    }

    override fun onStart() {
        Handler().postDelayed({
            title.text=sharedPreferences.getString("o","")
            Retrofit()
        }, 1)
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    fun Retrofit(){

        val call=RetrofitOneDays().getClient(title.text.toString())

        call.enqueue(object : Callback<MainExampleWeatherDay> {

            override fun onFailure(call: Call<MainExampleWeatherDay>, t: Throwable) {
                title.text=t.message.toString()
                Log.d("OY",t.message.toString())
                timeVisibility()
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<MainExampleWeatherDay>, response: Response<MainExampleWeatherDay>) {
                    if (response.isSuccessful) {
                        val mydata: MainExampleWeatherDay = response.body()!!
                        val mainEx=mydata.mainWeather
                        temperature.text = "Температура: " + mainEx?.temp?.toInt().toString()
                        pres.text="Атмосферное давление: "+(
                                mainEx?.pressure?.toDouble()!! /1.33307087
                                ).toInt().toString()
                        hum.text="Влажность: "+mainEx?.humidity.toString()

                        desc.text = mydata.weather?.get(0)?.description.toString()

                        clouds.text="Облачность: "+mydata.clouds?.all?.toString()+" %"
                        wind.text="Скорость ветра: "+mydata.wind?.speed.toString()+"м/с"

                    }
                }
        })
    }


    fun timeVisibility(){
        title.visibility=View.VISIBLE
        temperature.visibility=View.VISIBLE
    }

}