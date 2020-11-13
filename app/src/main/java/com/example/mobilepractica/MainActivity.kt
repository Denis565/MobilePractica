package com.example.mobilepractica

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.compose.navArgument
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mobilepractica.Fragment.CitySelectionFragment
import com.example.mobilepractica.Fragment.WeatherFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_city_selection.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val controller = Navigation.findNavController(this,R.id.nav_host_fragment)
        NavigationUI.setupWithNavController(bottomNavigationView,controller)
    }


}