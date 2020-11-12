@file:Suppress("DEPRECATION")

package com.example.mobilepractica.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobilepractica.BuildConfig
import com.example.mobilepractica.Interface.WeatherAPIInterface
import com.example.mobilepractica.Model.APIExample.MainExampleWeather
import com.example.mobilepractica.R
import com.example.mobilepractica.Retrafit.RetrofitOneDays
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


@Suppress("DEPRECATION")
class WeatherFragment : Fragment() {

    lateinit var sharedPreferences:android.content.SharedPreferences
    var lon:Double?=null
    var lat:Double?=null
    lateinit var call: Call<MainExampleWeather>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

    fun Retrofit(){

        val retrofit=RetrofitOneDays().getClient()
        val apiInterfaceInterface: WeatherAPIInterface =retrofit.create(WeatherAPIInterface::class.java)
            call= apiInterfaceInterface.getWeather(
                title.text.toString(),
                "metric",
                "ru",
                BuildConfig.OPEN_WEATHER_MAP_API_KEY
            )

        call.enqueue(object : Callback<MainExampleWeather> {

            override fun onFailure(call: Call<MainExampleWeather>, t: Throwable) {
                Toast.makeText(context,t.message.toString(),Toast.LENGTH_LONG).show()
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<MainExampleWeather>, response: Response<MainExampleWeather>) {
                if (response.isSuccessful) {
                        oneDay(response.body()!!)
                }
                else{
                    Toast.makeText(context,response.code().toString(),Toast.LENGTH_LONG).show()
                }
            }
        })

    }

    @SuppressLint("SetTextI18n", "DefaultLocale")
    fun oneDay(myData:MainExampleWeather){
        val mainEx=myData.mainWeather
        val heat=mainEx?.temp?.toInt()
       temperature.text = heat.toString()
        description.text=myData.weather?.get(0)?.description.toString().capitalize()

        clouds.text=myData.clouds?.all?.toString()+" %"
        pressure.text=(mainEx?.pressure?.toDouble()!! /1.33307087).toInt().toString()+" мм рт.ст"
        humidity.text=mainEx.humidity.toString()+" %"
        wind.text=myData.wind?.speed.toString()+"м/с"

        if ( heat!! > 15){
            advice.text="Идти купаться, или загорать."
        }
        else{
            advice.text="Оденься теплее."
        }

        relativeLayout.visibility=View.VISIBLE
        progressBar.visibility=View.GONE
    }
}