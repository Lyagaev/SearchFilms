package com.example.searchfilms.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class MovieList(
        @SerializedName("results")
        val  Movie: List<Film>
) : Parcelable


