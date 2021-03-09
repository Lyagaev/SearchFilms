package com.example.searchfilms.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Film(
        @SerializedName("title")
        val name : String,
        @SerializedName("vote_average")
        var rate : Double,
        @SerializedName("poster_path")
        var posterPath : String,
        @SerializedName("backdrop_path")
        var backdropPath : String,
        @SerializedName("id")
        var id : Int,
        @SerializedName("overview")
        var description : String,

        ) : Parcelable