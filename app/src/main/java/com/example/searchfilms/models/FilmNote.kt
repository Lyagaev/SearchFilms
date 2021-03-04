package com.example.searchfilms.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*


@Parcelize
data class FilmNote(
        val id_move: Int = 0,
        val note: String? = "Нет заметок"
) : Parcelable