package com.example.searchfilms.models

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(text: String,
                      actionText: String,
                      action: (View) -> Unit,
                      length: Int = Snackbar.LENGTH_INDEFINITE) {
    Snackbar.make(this, text, length).setAction(actionText, action).show()
}

fun getSettings(context: Context): Boolean {
    val sharedPref = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    var adultSettings = false
    if(sharedPref.contains(ADULT_SETTINGS)){
        adultSettings = sharedPref.getBoolean(ADULT_SETTINGS, false)
    }

    return adultSettings
}

fun getSettingsSharedPref(context: Context): SharedPreferences {
    return context.getSharedPreferences("settings", Context.MODE_PRIVATE)
}