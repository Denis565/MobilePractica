package com.example.mobilepractica.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.Visibility
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobilepractica.BuildConfig
import com.example.mobilepractica.ClassConstant
import com.example.mobilepractica.Interface.WeatherAPIInterface
import com.example.mobilepractica.Model.API.MainWeatherDay
import com.example.mobilepractica.Model.ClassAPI.MainExampleWeatherDay
import com.example.mobilepractica.R
import com.example.mobilepractica.Retrafit.RetrofitOneDays
import kotlinx.android.synthetic.main.fragment_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


@Suppress("DEPRECATION")
class WeatherFragment : Fragment() {

    lateinit var sharedPreferences:android.content.SharedPreferences
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
        val retrofitClass=RetrofitOneDays().getClient(ClassConstant.BASE_URL)
        val apiInterfaceInterface: WeatherAPIInterface =retrofitClass.create(WeatherAPIInterface::class.java)
        val call: Call<MainExampleWeatherDay> = apiInterfaceInterface.getWeather(title.text.toString(),"metric",BuildConfig.OPEN_WEATHER_MAP_API_KEY)

        call.enqueue(object : Callback<MainExampleWeatherDay> {

            override fun onFailure(call: Call<MainExampleWeatherDay>, t: Throwable) {
                title.text=t.message.toString()
                Log.d("OY",t.message.toString())
                timeVisibility()
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<MainExampleWeatherDay>, response: Response<MainExampleWeatherDay>) {
                if (response.isSuccessful){

                    val mydata: MainExampleWeatherDay= response.body()!!
                    temperature.text="Температура: "+ mydata.mainWeather?.temp?.toInt().toString()


                }
                else
                {
                    title.text="Вы ввели не правильно город"
                    progressBar.visibility=View.GONE
                    title.textSize=30.0F
                    title.visibility=View.VISIBLE
                }
            }


        })
    }

    fun timeVisibility(){
        progressBar.visibility=View.GONE
        title.visibility=View.VISIBLE
        temperature.visibility=View.VISIBLE
    }

}