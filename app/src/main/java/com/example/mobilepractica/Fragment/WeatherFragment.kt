package com.example.mobilepractica.Fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobilepractica.BuildConfig
import com.example.mobilepractica.Interface.WeatherAPI
import com.example.mobilepractica.Model.WeatherDay
import com.example.mobilepractica.R
import com.example.mobilepractica.SharedPreferences
import kotlinx.android.synthetic.main.fragment_weather.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Suppress("DEPRECATION")
class WeatherFragment : Fragment() {

    lateinit var sharedPreferences:android.content.SharedPreferences
    val BASE_URL = "http://api.openweathermap.org/data/2.5/";


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(activity)

    }

    override fun onStart() {
        Handler().postDelayed({ title.text=sharedPreferences.getString("o","") }, 1)
        super.onStart()

    }

}