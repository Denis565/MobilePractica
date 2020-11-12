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
        getings(view)
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
    }

    fun saveCity() {
        sharedPreference.edit().putString("o", editTextCity.text.toString()).apply()
    }

    fun getCity() {
        editTextCity.setText(sharedPreference.getString("o", "").toString())
    }

    fun getings(view: View) {
        this.listView = (view.findViewById(R.id.listView) as ListView?)!!
        this.button = view.findViewById(R.id.button) as Button?

        // CHOICE_MODE_NONE: (Default)
        // (listView.setItemChecked(..) doest not work with CHOICE_MODE_NONE).
        // CHOICE_MODE_SINGLE:
        // CHOICE_MODE_MULTIPLE:
        // CHOICE_MODE_MULTIPLE_MODAL:

        // CHOICE_MODE_NONE: (Default)
        // (listView.setItemChecked(..) doest not work with CHOICE_MODE_NONE).
        // CHOICE_MODE_SINGLE:
        // CHOICE_MODE_MULTIPLE:
        // CHOICE_MODE_MULTIPLE_MODAL:
        this.listView!!.choiceMode = ListView.CHOICE_MODE_MULTIPLE

        this.listView!!.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                Log.i(TAG, "onItemClick: $position")
                val v = view as CheckedTextView
                val currentCheck = v.isChecked
                val user: com.example.mobilepractica.Model.ListView =
                    listView!!.getItemAtPosition(position) as com.example.mobilepractica.Model.ListView
                user.isActive
            }
        //

        //
        this.button?.setOnClickListener { printSelectedItems() }

        this.initListViewData()
    }

    private fun initListViewData() {
        val tom = com.example.mobilepractica.Model.ListView("Tom", "admin")
        val jerry = com.example.mobilepractica.Model.ListView("Jerry", "user")
        val donald = com.example.mobilepractica.Model.ListView("Donald", "guest", false)
        val users: Array<com.example.mobilepractica.Model.ListView> = arrayOf<com.example.mobilepractica.Model.ListView>(tom, jerry, donald)

        // android.R.layout.simple_list_item_checked:
        // ListItem is very simple (Only one CheckedTextView).
        val arrayAdapter: ArrayAdapter<com.example.mobilepractica.Model.ListView>? =
            context?.let { ArrayAdapter<com.example.mobilepractica.Model.ListView>(it, android.R.layout.simple_list_item_checked, users) }
        this.listView!!.adapter = arrayAdapter
        for (i in users.indices) {
            this.listView!!.setItemChecked(i, users[i].isActive)
        }
    }

    fun printSelectedItems() {
        val sp = listView!!.checkedItemPositions
        var sb = StringBuilder()
        for (i in 0 until sp.size()) {
            if (sp.valueAt(i) == true) {
                val user: com.example.mobilepractica.Model.ListView =
                    listView!!.getItemAtPosition(i) as com.example.mobilepractica.Model.ListView
                // Or:
                // String s = ((CheckedTextView) listView.getChildAt(i)).getText().toString();
                //
                val s: String = user.userName
                sb = sb.append(" $s")
            }
        }
        Toast.makeText(context, "Selected items are: $sb", Toast.LENGTH_LONG).show()
    }
}