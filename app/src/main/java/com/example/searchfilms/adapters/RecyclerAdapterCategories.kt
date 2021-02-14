package com.example.searchfilms.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.R

class RecyclerAdapterCategories (private val values: MutableList<String>) :
        RecyclerView.Adapter<RecyclerAdapterCategories.MyViewHolder>() {

    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.recyclerview_categories_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textViewCategories?.text = values[position]
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewCategories: TextView? = null


        init {
            textViewCategories = itemView?.findViewById(R.id.text_view_categories)
            //smallTextView = itemView?.findViewById(R.id.textViewSmall)
        }
    }
}