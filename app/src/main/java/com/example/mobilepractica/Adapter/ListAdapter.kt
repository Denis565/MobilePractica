package com.example.mobilepractica.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mobilepractica.DateClass.ListModel
import com.example.mobilepractica.R

@Suppress("DEPRECATION")
class ListAdapter(var mCtx: Context, var resource: Int, var items: List<ListModel>) :
    ArrayAdapter<ListModel>(mCtx, resource, items) {

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resource, null)
        val textView: TextView = view.findViewById(R.id.title_row)
        val mItems: ListModel = items[position]
        textView.text = mItems.desc
        return view
    }
}

