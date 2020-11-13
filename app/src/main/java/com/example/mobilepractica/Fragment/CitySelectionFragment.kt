@file:Suppress("DEPRECATION")

package com.example.mobilepractica.Fragment

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.fragment.app.Fragment
import androidx.navigation.ActivityNavigator
import com.example.mobilepractica.R
import kotlinx.android.synthetic.main.fragment_city_selection.*


@Suppress("DEPRECATION")
class CitySelectionFragment : Fragment() {

    val myArray = listOf("ll", "ll", "ll", "ll", "ll", "ll", "ll", "ll", "ll")
    private lateinit var sharedPreference: android.content.SharedPreferences
    val TAG = "ListViewExample"

    private var listView: ListView? = null
    private var button: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_city_selection, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
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
        getCity()
        activity?.let { ActivityNavigator.applyPopAnimationsToPendingTransition(it) }
    }

    fun saveCity() {
        sharedPreference.edit().putString("city", editTextCity.text.toString()).apply()
    }

    fun getCity() {
        editTextCity.setText(sharedPreference.getString("city", "").toString())
    }

}