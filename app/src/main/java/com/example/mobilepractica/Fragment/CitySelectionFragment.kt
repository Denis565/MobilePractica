@file:Suppress("DEPRECATION")

package com.example.mobilepractica.Fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.BoringLayout
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
import com.example.mobilepractica.Dialog
import com.example.mobilepractica.R
import kotlinx.android.synthetic.main.fragment_city_selection.*
import kotlinx.android.synthetic.main.fragment_weather.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList


@Suppress("DEPRECATION")
class CitySelectionFragment : Fragment() {

    private val cityArray= listOf("Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Нижний Новгород", "Казань","Челябинск", "Омск", "Самара", "Ростов-на-Дону", "Уфа", "Красноярск", "Воронеж", "Пермь", "Волгоград", "Краснодар", "Саратов", "Тюмень", "Тольятти", "Ижевск", "Барнаул" , "Ульяновск" , "Иркутск" , "Хабаровск" , "Ярославоль" , "Владивосток" , "Махачкала" , "Томск" , "Оренбург", "Кемерово" , "Новокузнецк" , "Рязань" , "Астрахань" , "Пенза" , "Киров" , "Липецк" , "Чебоксары" , "Балашиха" , "Калининград" , "Тула")

    var cityAdd: ArrayList<String> = ArrayList()
    var cityAddElect: ArrayList<String> = ArrayList()
    private lateinit var sharedPreference: android.content.SharedPreferences
    var listCity: ListView? = null
    var listViewElect:ListView?=null
    var adapter: ArrayAdapter<String>? = null
    var adapterElect: ArrayAdapter<String>? = null
    private var arrayCityElect: Array<String?>?= arrayOfNulls(40)
    var start:Int?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_city_selection, container, false)
    }

    fun startCity():Int{
        return sharedPreference.getInt("start",0)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listCity=view.findViewById<ListView>(R.id.listView);
        listViewElect=view.findViewById(R.id.listViewElect)
        start=startCity()
        if (start==1){
            checkedSystem.visibility=View.GONE
        }
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
            if (!checkedSystem.isChecked ){
                listCity!!.visibility=View.VISIBLE
                listCity!!.isEnabled=true
                listViewElect!!.isEnabled=false
                listViewElect!!.visibility=View.GONE
                adapter?.clear()
                listCity!!.startAnimation(AnimationUtils.loadAnimation(context,R.anim.alpha_list_city))
            }else{

                listViewElect!!.visibility = View.VISIBLE
                listViewElect!!.isEnabled = true
                listCity!!.visibility = View.GONE
                listCity!!.isEnabled = false
                adapterElect?.clear()
                listViewElect!!.startAnimation(AnimationUtils.loadAnimation(context,R.anim.alpha_elect))

            }
            init()
        }
    }

    fun init(){
        cityArray.forEach {
            cityAdd.add(it)
        }
        adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_checked, cityAdd) }
        listCity!!.adapter = adapter

        for (i in 0..39){
            val sher=sharedPreference.getString("elect_$i","").toString()
            arrayCityElect!![i]=sher
            if (sher!="" && sher!="null") {
                cityAddElect.add(sher)
            }
        }

        adapterElect = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, cityAddElect) }
        listViewElect!!.adapter = adapterElect
    }

    fun removeListViewElected(){
        listViewElect!!.onItemLongClickListener =
            AdapterView.OnItemLongClickListener { _, _, pos, _ -> // TODO Auto-generated method stub

                val shareding= openElverShared()
                val elects=cityAddElect[pos]
                if (shareding!=elects) {
                    for (i in 0..cityArray.size) {
                        if (elects == cityArray[i]) {
                            arrayCityElect!![i] = ""
                            onPutSettings()
                            break
                        }
                    }

                    adapterElect!!.remove(cityAddElect[pos])
                    listViewElect!!.clearChoices()
                    adapterElect!!.notifyDataSetChanged()
                }
                else{
                    context?.let { Dialog().dialogInformation(
                        it,
                        "Предупреждение",
                        "Нельзя удалять город из списка,который выбран для вывода погоды.Для удаления этого города вам " +
                                "необходимо либо выбрать другой город для вывода информации из экрана с избраными городами, либо если " +
                                "в списке с избранными городами всего один город, добавте его из экрана со списком городов и потом выбрать " +
                                "его в избранных городах"
                    )}
                }

                true
            }
    }

    fun onClickCityEleven(){
        listViewElect!!.setOnItemClickListener { _, _, position, _ ->
            sharedPreference.edit().putString("Elects",cityAddElect[position]).apply()
        }
    }

    fun onClickCitySelected(){
        listCity!!.setOnItemClickListener { _, _, position, _ ->
            if (startCity()==1){
                val startCity=cityAdd[position]
                sharedPreference.edit().putString("Elects",startCity).apply()
                Toast.makeText(context,"Вы выбрали в качестве стартового горрода: $startCity",Toast.LENGTH_LONG).show()
                sharedPreference.edit().putInt("start",2).apply()
                checkedSystem.visibility=View.VISIBLE
                arrayCityElect!![position] = cityAdd[position]
                onPutSettings()
            }
            else {
                if (listCity!!.isItemChecked(position)) {
                    arrayCityElect!![position] = cityAdd[position]
                } else {
                    if (openShared(position)) {
                        arrayCityElect!![position] = ""
                    }
                }
                onPutSettings()
            }
        }
    }

    fun onPutSettings() {
        val edit=sharedPreference.edit()
        for (i in 0..39) {
            edit.remove("elect_$i")
            edit.putString("elect_$i",arrayCityElect!![i].toString()).apply()
        }
    }

    fun openElverShared():String{
         return sharedPreference.getString("Elects","").toString()
    }
    fun openShared(j:Int):Boolean{
        var boolean=true
        try {
            for (i in 0 until listViewElect?.count!!) {
                if (arrayCityElect!![j].toString() != cityAddElect[i]) {
                    boolean = true
                }
                else
                {
                    boolean=false
                    break
                }
            }
        }catch (e:Exception){
            Toast.makeText(context,"Не надо нажимать на один и тотже элемент по несколько раз в секунду. Благодарю за понимание.",Toast.LENGTH_LONG).show()
        }
        return boolean
    }


}