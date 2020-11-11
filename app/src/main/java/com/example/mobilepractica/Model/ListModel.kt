package com.example.mobilepractica.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ListModel(
    val desc:String
): Parcelable