package com.example.searchfilms.view

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainBroadcastReceiver : BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("ServiceCast")
    override fun onReceive(context: Context, intent: Intent) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager?.let{
            it.registerDefaultNetworkCallback(object : ConnectivityManager.NetworkCallback() {
                override fun onAvailable(network: Network) {
                    Toast.makeText(context, "Соединение с интернетом восстановлено", Toast.LENGTH_SHORT).show()
                }

                override fun onLost(network: Network) {
                    Toast.makeText(context, "Соединение с интернетом потеряно", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
