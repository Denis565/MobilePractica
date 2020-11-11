package com.example.mobilepractica.Fragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobilepractica.R
import com.example.mobilepractica.SharedPreferences
import kotlinx.android.synthetic.main.fragment_city_selection.*


@Suppress("DEPRECATION")
class CitySelectionFragment : Fragment() {

    val weatherFragment=WeatherFragment()

    private  lateinit var sharedPreference:android.content.SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city_selection, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreference=PreferenceManager.getDefaultSharedPreferences(context)
    }

   /* override fun onPause() {
        super.onPause()
      saveCity()
    }

    override fun onStart() {
        super.onStart()
        val sher= context?.let { SharedPreferences(it) }
        if(sher?.sharedPref!!.contains("key")){
            inputSearch.setText(sher.getValueString("key"))
        }

    }

    private fun saveCity() {
        val sher= context?.let { SharedPreferences(it) }
        sher?.save("key",inputSearch.text.toString())
    }*/

    override fun onPause() {
        super.onPause()
            saveCity()
    }

    override fun onStart() {
        super.onStart()
       get()
    }

    fun saveCity(){
        sharedPreference.edit().putString("o",inputSearch.text.toString()).apply()
    }

    fun get(){
        inputSearch.setText(sharedPreference.getString("o","").toString())
    }


}