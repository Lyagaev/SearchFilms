package com.example.searchfilms.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Film(
        val name: String,
        var rate: Double) : Parcelable