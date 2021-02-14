package com.example.searchfilms.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.Film
import com.example.searchfilms.R

class RecyclerAdapterFilms (private val values: MutableList<Film>) :
        RecyclerView.Adapter<RecyclerAdapterFilms.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_popular_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewPopularName?.text = values[position].name
        holder.textViewPopularRate?.text = values[position].rate.toString()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewPopularName: TextView? = null
        var textViewPopularRate: TextView? = null

        init {
            textViewPopularName = itemView?.findViewById(R.id.text_view_popular_name)
            textViewPopularRate = itemView?.findViewById(R.id.text_view_popular_rate)
        }
    }
}