@file:Suppress("DEPRECATION")

package com.example.mobilepractica.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.mobilepractica.R
import kotlinx.android.synthetic.main.fragment_city_selection.*
import java.util.*
import kotlin.collections.ArrayList


@Suppress("DEPRECATION")
class CitySelectionFragment : Fragment() {

    val cityArray= listOf("Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Казань","Челябинск", "Омск", "Самара", "Ростов-на-Дону", "Уфа", "Красноярск", "Воронеж", "Пермь", "Волгоград", "Краснодар", "Саратов", "Тюмень", "Тольятти", "Ижевск", "Барнаул" , "Ульяновск" , "Иркутск" , "Хабаровск" , "Ярославоль" , "Владивосток" , "Махачкала" , "Томск" , "Оренбург", "Кемерово" , "Новокузнецк" , "Рязань" , "Астрахань" , "Пенза" , "Киров" , "Липецк" , "Чебоксары" , "Балашиха" , "Калининград" , "Тула")

    var cityAdd: ArrayList<String> = ArrayList()
    var cityAddElect: ArrayList<String> = ArrayList()
    private lateinit var sharedPreference: android.content.SharedPreferences
    var listCity: ListView? = null
    var listViewElect:ListView?=null
    var adapter: ArrayAdapter<String>? = null
    var adapterElect: ArrayAdapter<String>? = null
    var arrayCityElect: Array<String?>?= arrayOfNulls(42)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_city_selection, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listCity=view.findViewById<ListView>(R.id.listView);
        listViewElect=view.findViewById(R.id.listViewElect)
        init()
        onClickCitySelected()
        onClickCheckBox()
        onClickCityEleven()
        removeListViewElected()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPreference = PreferenceManager.getDefaultSharedPreferences(context)
    }


    fun onClickCheckBox(){
        checkedSystem.setOnClickListener {
            if (!checkedSystem.isChecked){
                listCity!!.visibility=View.VISIBLE
                listCity!!.isEnabled=true
                listViewElect!!.isEnabled=false
                listViewElect!!.visibility=View.GONE
            }else{
                listViewElect!!.visibility=View.VISIBLE
                listViewElect!!.isEnabled=true
                listCity!!.visibility=View.GONE
                listCity!!.isEnabled=false
                adapterElect?.clear()
                init()
            }
        }
    }

    fun init(){
        cityArray.forEach {
            cityAdd.add(it)
        }
        adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_checked, cityAdd) }
        listCity!!.adapter = adapter

        for (i in 0..39){
            arrayCityElect!![i]=sharedPreference.getString("elect_$i","").toString()
        }

        arrayCityElect!!.forEach {
            if ( it!="" && it!=null) {
                cityAddElect.add(it.toString())
            }
        }

        adapterElect = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_checked, cityAddElect) }
        listViewElect!!.adapter = adapterElect
    }

    fun removeListViewElected(){
        listViewElect!!.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { arg0, arg1, pos, id -> // TODO Auto-generated method stub

                adapterElect!!.remove(cityAddElect[pos])
                listViewElect!!.clearChoices()
                adapterElect!!.notifyDataSetChanged()
                listViewElect!![pos].startAnimation(AnimationUtils.loadAnimation(context, R.anim.translate_list_view))

                true
            }
    }

    fun onClickCityEleven(){
        listViewElect!!.setOnItemClickListener { parent, view, position, id ->
            sharedPreference.edit().putString("Elect",cityAddElect[position]).apply()
        }
    }

    fun onClickCitySelected(){
        listCity!!.setOnItemClickListener { parent, view, position, id ->

            if (listCity!!.isItemChecked(position)) {
                arrayCityElect!![position] = cityAdd[position]
            }
            else{
                arrayCityElect!![position]=""
            }
            onPutSettings()
        }
    }

    fun onPutSettings() {
       val edit=sharedPreference.edit()
        for (i in 0..39) {
            edit.remove("elect_$i")
            edit.putString("elect_$i",arrayCityElect!![i].toString()).apply()
        }
        tv.text=""
        onShowSettings()
    }

    // считываем имена котов обратно
    fun onShowSettings() {
        var str=""
        for (i in 0..39) {
            val ret = sharedPreference.getString("elect_$i","")
            if (ret!="null" && ret!=""  && ret!=null) {
                str+=ret+"\n"
            }
        }
        tv.text=str
    }

}