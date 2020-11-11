package com.example.mobilepractica.Fragment

import android.content.Context
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mobilepractica.Adapter.ListAdapter
import com.example.mobilepractica.DateClass.ListModel
import com.example.mobilepractica.R
import com.example.mobilepractica.SharedPreferences
import kotlinx.android.synthetic.main.fragment_city_selection.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Suppress("DEPRECATION")
class CitySelectionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       val view = inflater.inflate(R.layout.fragment_city_selection, container, false)
        return view
    }


    /*fun AddCity(rootView:View){

        val myArray = listOf("ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll","ll")
        listView = rootView.findViewById(R.id.listView)
        val list= mutableListOf<ListModel>()
        myArray.forEach { list.add(ListModel(it)) }
        listView.adapter= context?.let { ListAdapter(it, R.layout.list_row,list) }

    }*/


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       /* CoroutineScope(Dispatchers.IO).launch {
            AddCity(view)
        }*/
    }



    override fun onResume() {
        super.onResume()
        val sher= context?.let { SharedPreferences(it) }
       Toast.makeText(context,sher?.save("key",inputSearch.text.toString()).toString(),Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        val sher= context?.let { SharedPreferences(it) }
        if(sher?.sharedPref!!.contains("key")){
            inputSearch.setText(sher.getValueString("key"))

        }

    }
}