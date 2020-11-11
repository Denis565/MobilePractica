package com.example.mobilepractica.DateClass

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ListModel(
    val desc:String
): Parcelable