package com.example.mobilepractica

import android.content.Context
import android.content.SharedPreferences
import android.text.BoringLayout
import android.util.Log

class SharedPreferences(context: Context) {
    private val PREFS_NAME = "Weather"
    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.putString(KEY_NAME, value)
        editor.apply()
    }

    fun getValueString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, "")
    }
}