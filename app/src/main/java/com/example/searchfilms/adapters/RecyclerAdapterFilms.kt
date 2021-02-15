package com.example.searchfilms.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.models.Film
import com.example.searchfilms.R
import com.example.searchfilms.models.OnItemViewClickListener
import kotlinx.android.synthetic.main.recyclerview_popular_item.view.*

/*
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

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewPopularName: TextView? = null
        var textViewPopularRate: TextView? = null

        init {
            itemView.setOnClickListener {
                Toast.makeText(
                        itemView.context,
                        "weather.city.city",
                        Toast.LENGTH_LONG
                ).show()
            }

            textViewPopularName = view?.findViewById(R.id.text_view_popular_name)
            textViewPopularRate = view?.findViewById(R.id.text_view_popular_rate)
        }
    }
}*/

class RecyclerAdapterFilms(private var onItemViewClickListener: OnItemViewClickListener?) :
        RecyclerView.Adapter<RecyclerAdapterFilms.MainViewHolder>() {

    private var filmData: List<Film> = listOf()

    fun setFilms(data: List<Film>) {
        filmData = data
        notifyDataSetChanged()
    }

    fun removeListener() {
        onItemViewClickListener = null
    }

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): MainViewHolder {
        return MainViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.recyclerview_popular_item, parent, false) as View
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(filmData[position])
    }

    override fun getItemCount(): Int {
        return filmData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(film: Film) {
            itemView.textView_popular_name.text =film.name
            itemView.text_view_popular_rate.text =film.rate.toString()
            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(film)
            }
        }
    }
}
