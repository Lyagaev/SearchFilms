package com.example.searchfilms.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Film(
        @SerializedName("original_title")
        val name: String,
        @SerializedName("vote_average")
        var rate: Double,
        @SerializedName("poster_path")
        var posterPath:String
        ) : Parcelable