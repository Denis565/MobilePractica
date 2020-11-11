package com.example.mobilepractica.Fragment

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobilepractica.R
import com.example.mobilepractica.SharedPreferences
import kotlinx.android.synthetic.main.fragment_weather.*


class WeatherFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onStart() {
        super.onStart()
        val sher= context?.let { SharedPreferences(it) }
        tv.text=sher?.getValueString("key")
    }

}