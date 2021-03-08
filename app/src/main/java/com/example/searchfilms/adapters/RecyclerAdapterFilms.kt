package com.example.searchfilms.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.searchfilms.models.Film
import com.example.searchfilms.R
import com.example.searchfilms.models.BASE_URL_IMAGE
import com.example.searchfilms.models.OnItemViewClickListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recyclerview_popular_item.view.*

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
            itemView.apply {
                textView_popular_name.text = film.name
                textView_popular_description.text = film.description
                text_view_popular_rate.text = film.rate.toString()
                Picasso
                        .get()
                        .load(BASE_URL_IMAGE+ "w200/"+ film.posterPath)
                        .into(image_popular);

                setOnClickListener {
                    onItemViewClickListener?.onItemViewClick(film)
                }
            }
        }
    }
}
